package io.qook.jweb;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties") // 기본 경로에서 읽어옴
public class JavaWebServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaWebServerApplication.class, args);
    }
}
