package com.tritonsfs.springboot.controller;

import com.tritonsfs.springboot.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 2018/9/28 14:45 by 刘赵强
 **/
@Controller
public class SampleController {

    @Autowired
    private MailSendService mailSendService;

    @RequestMapping("/")
    @ResponseBody
    String helloWorld() {
        return "Hello World!";
    }

    /**
     * 跳转到html页面
     * @return 成功标识
     */
    @RequestMapping("/greeting")
    public String greeting(){
        return "greeting";
    }
    @RequestMapping("/saveTransaction")
    @ResponseBody
    public String saveTransaction(){
        mailSendService.testA();
        return "ok";
    }


}
