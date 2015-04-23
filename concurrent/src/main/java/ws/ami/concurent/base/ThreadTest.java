package ws.ami.concurent.base;

import java.math.BigDecimal;

/**
 * Created by hp on 2015/4/21.
 */
public class ThreadTest {

    public static void main(String[] args) {
       /* Thread1 t = new Thread1();
        String a = t.say();
        System.out.println(a);*/
        BigDecimal bg = new BigDecimal(2.0);
        BigDecimal bg1 = new BigDecimal(1.2);
        BigDecimal bg2 = new BigDecimal(1.2);

        Double bga = bg.add(bg1).doubleValue();
        bg.add(bg2);


        System.out.println(bga);

    }
}
