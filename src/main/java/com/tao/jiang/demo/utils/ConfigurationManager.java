package com.tao.jiang.demo.utils;

import com.mongodb.MongoClient;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.TimeZone;


@Component
public class ConfigurationManager {
    private ConfigurationManager instance ;
    private Log log = LogFactory.getFactory().getInstance(ConfigurationManager.class);

    @Value("spring.data.mongodb.database")
    private String databaseName;

    @Value("spring.data.mongodb.file.database")
    private String fileDatabaseName;

    @Value("spring.data.mongodb.host")
    private String host;

    @Value("spring.data.mongodb.port")
    private int port;


    private MongoOperations fmwMongoDB;
    private MongoOperations fmwFileMongoDB;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        this.fmwMongoDB = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(host, port), databaseName));
        this.fmwFileMongoDB = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(host,port), fileDatabaseName));
        instance = this;
    }

    public ConfigurationManager getInstance() {
        return instance;
    }
}
