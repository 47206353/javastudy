package ws.ami.concurent.fasleshare;

/**
 * 该类展示了缓存缺失的其中一种情况：请注意现代cpu一般缓存有三级，L1，L2，L3.其中L1离cpu最近
 * L3离cpu最远。L1,L2一般为一个cpu专有，L3为多个cpu共享
 * 
 * 
 * 在加载longs[i][j]时, longs[i][j+1]很可能也会被加载至cache中, 所以立即访问longs[i][j+1]将会命中L1
 * Cache, 而如果你访问longs[i+1][j]情况就不一样了, 这时候很可能会产生 cache miss导致效率低下.
 * 
 * 
 * 我只是示例了在L1 Cache满了之后才会发生的cache miss. 其实cache miss的原因有下面三种: 1. 第一次访问数据,
 * 在cache中根本不存在这条数据, 所以cache miss, 可以通过prefetch解决. 2. cache冲突, 需要通过补齐来解决. 3.
 * 就是我示例的这种, cache满, 一般情况下我们需要减少操作的数据大小, 尽量按数据的物理顺序访问数据. 具体的信息可以参考这篇论文.
 *
 */

public class L1CacheMiss {

	private static final int RUNS = 10;

	// 行
	private static final int row = 1024 * 1024;

	// 列
	private static final int col = 62;

	private static long[][] longs;

	public static void main(String[] args) throws Exception {

		Thread.sleep(10000);

		longs = new long[row][];

		for (int i = 0; i < row; i++) {

			longs[i] = new long[col];

			for (int j = 0; j < col; j++) {

				longs[i][j] = 0L;

			}

		}

		System.out.println("starting....");

		final long start = System.nanoTime();

		long sum = 0L;

		for (int r = 0; r < RUNS; r++) {

			// 先遍历列，在遍历行

			for (int j = 0; j < col; j++) {

				for (int i = 0; i < row; i++) {

					sum += longs[i][j];

				}

			}

			// 先遍历行在遍列，再遍历行
			/*
			 * for (int i = 0; i < row; i++) {
			 * 
			 * for (int j = 0; j < col; j++) {
			 * 
			 * sum += longs[i][j];
			 * 
			 * }
			 * 
			 * }
			 */

		}

		System.out.println("duration = " + (System.nanoTime() - start));

	}

}
