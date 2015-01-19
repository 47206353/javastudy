package ws.ami.concurent.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试:
 * ThreadPoolExecutor线程的任务规则：
 * 输入参数：核心线程数：5  最大线程数：10  阻塞队列:10
 * 1.当线程池中线程数目小与核心线程数目时候，向线程池增加任务，则线程池接收任务，并新建线程。            if  任务<5
 * 2.当线程池中数目大于核心线程数据，此时向线程池增加任务，则将任务放入到阻塞队列中。                          if  5《任务《15
 * 3.当阻塞队列满，此时向线程池增加任务，则将任务放入到线程池。线程池接收任务，新建线程                      if  15《任务《20
 * 4.当线程池中任务到达最大线程池中数，阻塞队列也满，此时再向线程池中加入任务，线程池调用拒绝策略。 if   20<任务
 * 
 * @author hp
 *
 */

public class ThreadExcutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Executor e = Executors.newCachedThreadPool();

		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(
				10);

		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 0,
				TimeUnit.SECONDS, workQueue, new MyThreadFactrory(),
				new MyRejectPolicy());

		for (int i = 0; i < 200; i++) {

			Runnable runnable = new Runnable() {
				int j = 0;

				public void run() {
					while (j < 20) {
						try {
							Thread.sleep(5000);
							j++;
							//System.out.println("ThreadName = "+Thread.currentThread().getName() +" j = " + j);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					
					}

				}
			};

			
			poolExecutor.execute(runnable);
			System.out.println("向线程池中加入第 " + (i+1) + " 线程");
			System.out.println("workQueue 中的线程数目 = "+workQueue.size());
			
			System.out.println("线程池中活动线程的线程数目   active Count= "+poolExecutor.getActiveCount());
			System.out.println("线程池中core线程的线程数目   core pool Count= "+poolExecutor.getCorePoolSize());
			System.out.println("线程池中core线程的线程数目   MaximumPoolSize= "+poolExecutor.getMaximumPoolSize());
			System.out.println("线程池中core线程的线程数目   PoolSize= "+poolExecutor.getPoolSize());
			System.out.println("线程池中core线程的线程数目   LargestPoolSize= "+poolExecutor.getLargestPoolSize());
			

		}

	}

}
