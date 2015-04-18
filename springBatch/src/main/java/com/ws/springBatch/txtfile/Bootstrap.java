package com.ws.springBatch.txtfile;

import com.google.common.util.concurrent.AbstractIdleService;
import org.quartz.impl.StdScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.scheduling.quartz.SimpleTriggerBean;

/**
 * Created by hp on 2015/3/16.
 */
public class Bootstrap extends AbstractIdleService {

    private Bootstrap() {
    }

    private final static Logger log = LoggerFactory.getLogger(Bootstrap.class);

    private ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.startAsync();
        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
            log.error("ignore interruption ");
        }
    }

    /**
     * Start the service.
     */
    @Override
    protected void startUp() throws Exception {
        context = new ClassPathXmlApplicationContext("/txtfile/applicationContext.xml");
        context.start();
        context.registerShutdownHook();

        StdScheduler myScheduler = (StdScheduler) context.getBean("myScheduler");
        SimpleTriggerBean myTrigger = (SimpleTriggerBean) context.getBean("myTrigger");
        JobDetailBean myJob = (JobDetailBean) context.getBean("myJob");
        myScheduler.scheduleJob(myJob, myTrigger);

        log.info("exception service started successfully");
    }

    /**
     * Stop the service.
     */
    @Override
    protected void shutDown() throws Exception {
        context.stop();
        log.info("service stopped successfully");
    }

}


