package com.ws.ami.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hp on 2015/2/3.
 */
public class DubboClientTester {

    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-test");

        ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>();
        reference.setUrl("dubbo://127.0.0.1:8989/com.ws.ami.dubbo.DemoService");
        reference.setTimeout(500);
        reference.setConnections(10);
        reference.setApplication(application);
        reference.setInterface(DemoService.class);
        reference.setVersion("1.0.0");
        final DemoService blogQueryService = reference.get();

        long begin = System.currentTimeMillis();
        System.out.println(blogQueryService.sayHello());
        long end = System.currentTimeMillis();
        System.out.println(" cost:" + (end - begin));

        ExecutorService es = Executors.newFixedThreadPool(50, new NamedThreadFactory("my test"));
        List<Callable<String>> tasks = new ArrayList<Callable<String>>();
        for (int i = 0; i < 100000; ++i) {
            tasks.add(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    System.out.println("run");
                    System.out.println(blogQueryService.sayHello());
                    System.out.println("run success");
                    return null;
                }
            });
        }
        List<Future<String>> futurelist = es.invokeAll(tasks);
        for (Future<String> future : futurelist) {
            try {
                String result = future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------\r\n");
        }
        es.shutdown();
        System.out.println("end");
        System.in.read();
    }

    static class NamedThreadFactory implements ThreadFactory {

        private static final AtomicInteger POOL_SEQ   = new AtomicInteger(1);

        private final AtomicInteger        mThreadNum = new AtomicInteger(1);

        private final String               mPrefix;

        private final boolean              mDaemo;

        private final ThreadGroup          mGroup;

        public NamedThreadFactory(){
            this("pool-" + POOL_SEQ.getAndIncrement(), false);
        }

        public NamedThreadFactory(String prefix){
            this(prefix, false);
        }

        public NamedThreadFactory(String prefix, boolean daemo){
            mPrefix = prefix + "-thread-";
            mDaemo = daemo;
            SecurityManager s = System.getSecurityManager();
            mGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
        }

        public Thread newThread(Runnable runnable) {
            String name = mPrefix + mThreadNum.getAndIncrement();
            Thread ret = new Thread(mGroup, runnable, name, 0);
            ret.setDaemon(mDaemo);
            return ret;
        }

        public ThreadGroup getThreadGroup() {
            return mGroup;
        }

    }
}