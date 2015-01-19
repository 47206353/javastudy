package ws.ami.concurent.fasleshare;

import java.util.HashMap;

public class ts {

	static HashMap<String, byte[]> s = new HashMap<String, byte[]>();
	static Integer i = 0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		sat();

	}

	public static synchronized void sat() throws InterruptedException {

		for (;;) {
			i++;
			s.put(i.toString(), new byte[100*100*100]);

			System.out.print("b");
			Thread.sleep(1);
		}

	}

}
