package com.tritonsfs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author 2018/9/28 14:35 by 刘赵强
 **/

@SpringBootApplication
@ComponentScan({"com.tritonsfs.cac.redis","com.tritonsfs.cac.mq","com.tritonsfs.springboot"})
@EnableRetry
public class SpringBootDemo1Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo1Application.class, args);
    }

}
