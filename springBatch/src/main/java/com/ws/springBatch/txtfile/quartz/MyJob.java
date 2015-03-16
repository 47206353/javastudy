package com.ws.springBatch.txtfile.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
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
            Job myJob = (Job) applicationContext.getBean("helloWorldJob");
            //通过JobParameter在程序运行期间动态获取文件路径
            JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
            jobParametersBuilder.addString("InputFilePath","/txtfile/user2.txt");
            launcher.run((myJob) , jobParametersBuilder.toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
