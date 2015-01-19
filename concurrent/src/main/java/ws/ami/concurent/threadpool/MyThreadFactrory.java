package ws.ami.concurent.threadpool;

import java.util.concurrent.ThreadFactory;

/**
 * 线程池工厂
 * @author hp
 *
 */

public class MyThreadFactrory implements ThreadFactory {

	public Thread newThread(Runnable r) {
		
		System.out.println("新建线程");

		Thread thread = new Thread(r);

		return thread;
	}

}
