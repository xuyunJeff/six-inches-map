package com.six.map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SixMapApplication {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SixMapApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        log.info("The Six-Map application has been started successfully!");
    }
}
