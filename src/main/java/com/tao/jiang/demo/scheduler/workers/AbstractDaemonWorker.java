package com.tao.jiang.demo.scheduler.workers;

public abstract class AbstractDaemonWorker implements Runnable {
    @Override
    public void run() {
        try{
            execute();
        }catch (Exception e){

        }
    }

    protected abstract void execute() throws Exception;

    protected enum WorkerStatus{
        SUCC, FAILED, RUNNING
    }
}
