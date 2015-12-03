import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hp on 2015/8/4.
 */
@RestController
@EnableAutoConfiguration
public class Hello {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    public static void main(String[] args) throws Exception {


        System.out.println("get_khdy".hashCode());
        SpringApplication.run(Hello.class, args);
    }
}
