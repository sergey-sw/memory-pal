package xyz.skywind;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/03/2018.
 */
@Controller
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"xyz.skywind"})
public class AppController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppController.class, args);
    }
}
