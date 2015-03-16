package com.ws.springBatch.txtfile.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Map;


/**
 * Created by hp on 2015/3/16.
 */
@Slf4j
public class MyJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        log.info("开始定时任务");

        Map dataMap = context.getJobDetail().getJobDataMap();
        ApplicationContext applicationContext = (ApplicationContext) dataMap.get("applicationContext");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) applicationContext.getBean("jobRepository"));
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        try {
            launcher.run((org.springframework.batch.core.Job) applicationContext.getBean("helloWorldJob"), new JobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
