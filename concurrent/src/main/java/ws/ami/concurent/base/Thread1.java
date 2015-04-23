package ws.ami.concurent.base;

/**
 * Created by hp on 2015/4/21.
 */
public class Thread1 {

    public String say() {
        String a = "hello ";
        Thread2 t2 = new Thread2();
        t2.say();

        return a;
    }
}
