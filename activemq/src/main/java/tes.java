/**
 * Created by hp on 2015/1/8.
 */
public class tes {

    public static void main(String[] args)
    {
        String a = "172.27.1.17:2181?backup=172.27.1.18:2181,172.27.1.19:2181,172.27.1.17:2182,172.27.1.18:2182";
        String b ="172.27.1.17:2181?backup=172.27.1.18:2181,172.27.1.19:2181,172.27.1.17:2182,172.27.1.18:2182";
        System.out.println(a==b);

    }
}
