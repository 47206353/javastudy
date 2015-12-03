/**
 * Created by hp on 2015/8/4.
 */
public class test {

    public static void main(String[] args) throws InterruptedException {

        java.util.Date date = new java.util.Date();

        long time = date.getTime();

       // Thread.sleep(1);
        java.util.Date date2 = new java.util.Date();
        long time2 = date2.getTime();

        System.out.println(time2-time);


        long now1 = System.currentTimeMillis();
        java.util.Date time3 = new java.util.Date(now1);
        for(int i=0;i<1000000000;i++)
            date2.getTime();
         //System.out.println("");

        long now2 = System.currentTimeMillis();
        java.util.Date time4 = new java.util.Date(now2);

        System.out.println(now2 - now1);



    }
}
