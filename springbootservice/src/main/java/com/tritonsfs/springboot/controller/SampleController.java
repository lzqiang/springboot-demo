package com.tritonsfs.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2018/9/28 14:45 by 刘赵强
 **/
@Controller
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String helloWorld() {
        return "Hello World!";
    }
    @RequestMapping("/greeting")
    public String greeting(){
        return "greeting";
    }
}
