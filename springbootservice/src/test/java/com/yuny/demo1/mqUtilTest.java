package com.yuny.demo1;

import com.tritonsfs.cac.mq.core.BlackuioPayCallbackNotifyUtil;
import com.tritonsfs.springboot.SpringBootDemo1Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 2018/11/20 11:11 by 刘赵强
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootDemo1Application.class})
public class mqUtilTest {
    @Test
    public void test(){
        Map<String,String> map = new HashMap<>(2);
        map.put("name","lzqiang");
        map.put("age:","26");
        BlackuioPayCallbackNotifyUtil.sendToMsg(map);
    }
}
