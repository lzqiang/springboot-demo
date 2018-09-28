package com.yuny.demo1;

import com.tritonsfs.springboot.SpringBootDemo1Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo1ApplicationTests {
    private Logger logger = LoggerFactory.getLogger(SpringBootDemo1Application.class);

    @Test
    public void contextLoads() {
        logger.error("text");
    }
}
