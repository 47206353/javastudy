package ws.ami.concurent.fasleshare;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 两个逻辑一模一样的程序, 前者只需要9秒, 后者跑了将近一分钟, 这太不可思议了! 我们用伪共享(False Sharing)的理论来分析一下.
 * 后面的那个程序longs数组的4个元素, 由于VolatileLong只有1个长整型成员, 所以整个数组都将被加载至同一缓存行,
 * 但有4个线程同时操作这条缓存行, 于是伪共享就悄悄地发生了. 读者可以测试一下2,4,8, 16个线程分别操作时分别是什么效果, 什么样的趋势.
 * 
 * 那么怎么避免伪共享呢? 我们未注释的代码就告诉了我们方法. 我们知道一条缓存行有64字节,
 * 而Java程序的对象头固定占8字节(32位系统)或12字节(64位系统默认开启压缩, 不开压缩为16字节), 详情见 链接.
 * 我们只需要填6个无用的长整型补上6*8=48字节, 让不同的VolatileLong对象处于不同的缓存行,
 * 就可以避免伪共享了(64位系统超过缓存行的64字节也无所谓, 只要保证不同线程不要操作同一缓存行就可以). 这个办法叫做补齐(Padding).
 * 
 * @author hp
 *
 */

public final class FalseSharing implements Runnable {

	public static int NUM_THREADS = 4; // change

	public final static long numbers = 500L * 1000L * 1000L;

	private final int arrayIndex;

	private static VolatileLong[] longs;

	public FalseSharing(final int arrayIndex) {

		this.arrayIndex = arrayIndex;

	}

	public static void main(final String[] args) throws Exception {

		Thread.sleep(100);

		System.out.println("starting....");

		if (args.length == 1) {

			NUM_THREADS = Integer.parseInt(args[0]);

		}

		longs = new VolatileLong[NUM_THREADS];

		for (int i = 0; i < longs.length; i++) {

			longs[i] = new VolatileLong();

		}

		final long start = System.nanoTime();

		runTest();

		System.out.println("duration = " + ((System.nanoTime() - start))
				/ 1000000000);

	}

	private static void runTest() throws InterruptedException {

		Thread[] threads = new Thread[NUM_THREADS];

		for (int i = 0; i < threads.length; i++) {

			threads[i] = new Thread(new FalseSharing(i));

		}

		for (Thread t : threads) {

			t.start();

		}

		for (Thread t : threads) {

			t.join();

		}

	}

	public void run() {

		long i = numbers + 1;

		while (0 != --i) {

			longs[arrayIndex].value = i;

		}

	}

	public final static class VolatileLong {

		// Java程序的对象头固定占8字节(32位系统)或12字节
		// (64位系统默认开启压缩, 不开压缩为16字节), 详情见 链接. 我们只需要填6个无用的长整型补上6*8=48字节,
		// 让不同的VolatileLong对象处于不同的缓存行, 就可以避免伪共享了
		// (64位系统超过缓存行的64字节也无所谓,只要保证不同线程不要操作同一缓存行就可以).

		public volatile long value = 0L;

		public long p1, p2, p3, p4, p5, p6=7l; // 注释

	}

	public static class PaddedAtomicLong extends AtomicLong

	{

		public volatile long p1, p2, p3, p4, p5, p6 ;

	}

}
