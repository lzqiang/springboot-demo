package com.tritonsfs.springboot.service;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * @author 2018/11/20 11:25 by 刘赵强
 **/
@Component
public class MQConsumer {
    @JmsListener(destination = "blackuiopay.queue.test")
    public void doNotify(Map<String, String> signParamsMap) {
        System.out.println(signParamsMap);
        for(String key:signParamsMap.keySet()){
            System.out.println(key+"...."+signParamsMap.get(key));
        }
    }
}
