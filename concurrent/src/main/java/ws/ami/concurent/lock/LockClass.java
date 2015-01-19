package ws.ami.concurent.lock;

public class LockClass {
	
	private static  void say() {
		System.out.println("say hello");
	}
	
	public static void main(String[] args)  {
		
		Thread thread = new Thread(new Runnable() {		
			public void run() {
				
				synchronized(LockClass.class)
				{
					System.out.println("say lock");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		thread.start();
		
		say();
	}

}
