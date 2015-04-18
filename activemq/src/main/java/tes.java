import java.util.Objects;

/**
 * Created by hp on 2015/1/8.
 */
public class tes {

    public static void main(String[] args) {
        String a = new String();
        String b =new String();
        Class p = a.getClass();
        for (int i = 0; i < 10; i++) {

            System.out.println(p.toString( )+" p is instance of object ="+ p.equals(Object.class));
            System.out.println(p.hashCode());
            p = p.getClass().getSuperclass();
        }

    }
}
