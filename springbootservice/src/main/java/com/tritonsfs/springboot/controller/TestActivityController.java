package com.tritonsfs.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.tritonsfs.cac.depository.core.dto.ResultBean;
import com.tritonsfs.cac.depository.util.constant.BizPrompt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 2018/11/16 14:54 by 刘赵强
 **/
@RestController
@RequestMapping("act/testAnnotation")

public class TestActivityController {

    @RequestMapping(value="/test", produces = { "text/html;charset=UTF-8;", "application/json;" })
    @ActivityAnnotation(activityId = "4")
    public String test(){
        Map<String,String> map = new HashMap<>(2);
        map.put("a","1");
        map.put("b","2");
        ResultBean<?> resultBean = new ResultBean<>(BizPrompt.SUCCESS,map);
        return JSON.toJSONString(resultBean.getModel());
    }

    @RequestMapping("test2")
    public void test2(){
        int i = 1+1;
        System.out.println("test"+i);
    }
}
