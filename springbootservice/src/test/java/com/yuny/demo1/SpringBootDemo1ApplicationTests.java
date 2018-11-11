package com.yuny.demo1;

import com.tritonsfs.springboot.SpringBootDemo1Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootDemo1ApplicationTests {
    @Test
    public void contextLoads() {
        log.error("text");
    }
}
