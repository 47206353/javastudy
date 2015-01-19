package ws.ami.concurent.base;

/**
 * 上面的类展示了final字段应该如何使用。一个正在执行reader方法的线程保证看到f.x的值为3
 * ，因为它是final字段。它不保证看到f.y的值为4，因为f.y不是final字段。
 * 
 * @author hp
 *
 */
class FinalFieldExample {
	
	
	final int x;
	int y;
	static FinalFieldExample f;

	public FinalFieldExample() {
		x = 3;
		y = 4;
	}

	/*
	 * 如果FinalFieldExample的构造方法像这样： 那么，从global.obj中读取this的引用线程不会保证读取到的x的值为3。
	 * 能够看到字段的正确的构造值固然不错，但是，如果字段本身就是一个引用， 那么，你还是希望你的代码能够看到引用所指向的这个对象（或者数组）的最新值。
	 * 如果你的字段是final字段，那么这是能够保证的。因此，当一个final指针指向一个数组，
	 * 你不需要担心线程能够看到引用的最新值却看不到引用所指向的数组的最新值。
	 * 重复一下，这儿的“正确的”的意思是“对象构造方法结尾的最新的值”而不是“最新可用的值”。 public FinalFieldExample() {
	 * // bad! x = 3; y = 4; // bad construction - allowing this to escape
	 * global.obj = this; }
	 */

	static void writer() {
		f = new FinalFieldExample();
	}

	static void reader() {
		if (f != null) {
			int i = f.x;
			int j = f.y;
		}
	}

	public static void main(String[] args) {
		
		reader();

	}
}
