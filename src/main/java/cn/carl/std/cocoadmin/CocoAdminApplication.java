package cn.carl.std.cocoadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync //开启异步支持
@SpringBootApplication
public class CocoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocoAdminApplication.class, args);
    }
}
