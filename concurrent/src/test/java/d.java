import org.junit.Test;
import ws.ami.concurent.base.Thread1;

/**
 * Created by hp on 2015/2/3.
 */
public class d {

    @Test
    public void test()
    {
        Thread1 t = new Thread1();
        String a = t.say();
        System.out.println(a);
    }
}
