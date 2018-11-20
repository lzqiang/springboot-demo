package com.yuny.demo1;

import com.tritonsfs.springboot.SpringBootDemo1Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 2018/11/19 15:51 by 刘赵强
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootDemo1Application.class})
public class RedisUtil {
    @Test
    public void test(){
        com.tritonsfs.cac.redis.util.RedisUtil.set("a","1");
        System.out.println("aaaaa");
    }
    @Test
    public void testget(){
        Object o = com.tritonsfs.cac.redis.util.RedisUtil.get("a");
        System.out.println("==========="+o+"=========");
    }

    @Test
    public void lock(){
       if(com.tritonsfs.cac.redis.util.RedisUtil.lock("testlock",String.valueOf(System.currentTimeMillis()))){
           System.out.println("lock");
       }
    }

    @Test
    public void testIncrement(){
        long b = com.tritonsfs.cac.redis.util.RedisUtil.incrementLong("e", 1);
        System.out.println("b=="+b);
    }

    @Test
    public void getIncrement(){
        Object e = com.tritonsfs.cac.redis.util.RedisUtil.get("e");
        System.out.println("e=="+e);
    }

    @Test
    public void testIncrement2(){
        double b = com.tritonsfs.cac.redis.util.RedisUtil.incrementDouble("f", 0.5d);
        System.out.println("b=="+b);
    }
}
