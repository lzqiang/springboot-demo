package com.tritonsfs.springboot.controller;

import com.tritonsfs.cac.mq.core.BlackuioPayCallbackNotifyUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 2018/11/20 11:23 by 刘赵强
 **/
@Controller
@RequestMapping("mq/testmq")
public class MQController {

    @RequestMapping("/add")
    @ResponseBody
    public String addmq(){
        Map<String,String> map = new HashMap<>(2);
        map.put("name","lzqiang");
        map.put("age:","26");
        Queue queue = new ActiveMQQueue("blackuiopay.queue.test");
        BlackuioPayCallbackNotifyUtil.setQueue(queue);
        BlackuioPayCallbackNotifyUtil.sendToMsg(map);
        return "add success";
    }
}
