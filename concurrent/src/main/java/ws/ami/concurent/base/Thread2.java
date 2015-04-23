package ws.ami.concurent.base;

/**
 * Created by hp on 2015/4/21.
 */
public class Thread2 {

    public String say() {
        String a = "hello ";
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 999999; i++)
                    System.out.println("i = " + i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        };
        Thread t = new Thread(r);
        t.start();
        return a;
    }
}
