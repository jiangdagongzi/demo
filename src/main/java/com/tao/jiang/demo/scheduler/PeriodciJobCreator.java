package com.tao.jiang.demo.scheduler;

import ch.qos.logback.core.util.TimeUtil;
import com.tao.jiang.demo.scheduler.workers.AbstractDaemonWorker;
import javafx.scene.control.RadioMenuItem;
import org.apache.commons.io.IOUtils;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.rocketmq.common.utils.IOTinyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class PeriodciJobCreator implements ApplicationRunner {
    private Log log = LogFactory.getFactory().getInstance(PeriodciJobCreator.class);

    private ScheduledExecutorService scheduledExecutorService;
    private Random rd = new Random();

    @Value("${timer.threadPool.size}")
    private int threadPoolSize;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        scheduledExecutorService = Executors.newScheduledThreadPool(threadPoolSize);
        List<String> configRecords = IOUtils.readLines(PeriodciJobCreator.class.getResourceAsStream("/daemons.config"));
        configRecords.stream()
                .filter(line -> !line.trim().startsWith("#"))
                .forEach(this::addDaemonWorker);
    }

    private void addDaemonWorker(String line) {
        String[] fields = line.trim().split("---");
        if (fields.length <= 2) {
            String daemonWorkerClass = fields[0].trim();
            int interval = Integer.parseInt(fields[1].trim());
            int delay = rd.nextInt(60);
            if (fields.length >= 3) {
                delay = Integer.parseInt(fields[2]);
            }
            try {
                Class<AbstractDaemonWorker> cls = (Class<AbstractDaemonWorker>) Class.forName(daemonWorkerClass);
                AbstractDaemonWorker worker = cls.newInstance();
                scheduledExecutorService.scheduleWithFixedDelay(worker, delay, interval, TimeUnit.SECONDS);
                log.info("Added scheduler for " + daemonWorkerClass + " every " + interval + " seconds");
            } catch (Exception e) {
                log.error("Failed to add scheduler for " + daemonWorkerClass + " every " + interval + " seconds ", e);
            }
        } else {
            log.error("The format is not correct " + line);
        }
    }

    public void shutdown() {
        scheduledExecutorService.shutdown();
    }

    //TODO add logic to schedule one time job
    public void scheduleOneTileJob(Runnable runnable) {

    }

}
