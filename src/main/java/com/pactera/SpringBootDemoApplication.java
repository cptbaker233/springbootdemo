package com.pactera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.ArrayList;


@SpringBootApplication
public class SpringBootDemoApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);

    public static void main(String[] args) throws Exception {
        logger.info("正在启动springboot项目......");
        new SpringApplicationBuilder(SpringBootDemoApplication.class).run(args);
        while (true) {
            String[] arr = new String[10000];
            Thread.sleep(100);
        }
    }

}