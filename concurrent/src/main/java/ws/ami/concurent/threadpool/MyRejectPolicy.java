package ws.ami.concurent.threadpool;

import java.util.concurrent.RejectedExecutionException;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 拒绝策略
 * @author hp
 *
 */

public class MyRejectPolicy implements RejectedExecutionHandler {

	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("拒绝");
              throw new RejectedExecutionException("线程池拒絕");

	}

}
