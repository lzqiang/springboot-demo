package com.tritonsfs.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2018/9/28 14:45 by 刘赵强
 **/
@RestController
public class SampleController {

    @RequestMapping("/")
    String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/testJson")
    public String testJson(){
        return "{'content':'ceshi'}";
    }
}
