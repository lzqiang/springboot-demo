package com.tritonsfs.springboot.schedule;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 2018/11/3 10:50 by 刘赵强
 **/
@Configuration
@EnableScheduling
@Component
@Slf4j
public class CacSign {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Value("${cacLoginUrl}")
    private String loginUrl;
    @Value("${phone}")
    private String phone;
    @Value("${passowrd}")
    private String password;
    @Value("${cacSignUrl}")
    private String cacSignUrl;

    @Scheduled(cron = "0/10 * * * * ? ")
    public void test() {
        log.error("当前时间={}", simpleDateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 0 10 * * ? ")
    public void work() {
        cacSign();
    }

    public JSONObject cacSign() {
        JSONObject jsonObject;
        try {
            jsonObject = loginCac();
        } catch (Exception e) {
            log.error("登录失败,errorMsg={}", e.getMessage(), e);
            return null;
        }
        if (null != jsonObject) {
            JSONObject model = jsonObject.getJSONObject("model");
            String userId = model.getString("userId");
            String loginToken = model.getString("loginToken");
            if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(loginToken)) {
                try {
                    return sign(userId, loginToken);
                } catch (Exception e) {
                    log.error("签到失败,errorMsg={}", e.getMessage(), e);
                }
            } else {
                log.error("userId或loginToken为空");
            }
        }
        return null;
    }

    /**
     * 登录
     *
     * @return
     */
    private JSONObject loginCac() {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("blackbox", "01");
        paramsMap.put("device", "01");
        paramsMap.put("passWord", password);
        paramsMap.put("phoneNo", phone);
        String body = HttpUtil.post(loginUrl, paramsMap);
        return JSONObject.parseObject(body);
    }

    /**
     * 签到
     *
     * @return
     */
    private JSONObject sign(String userId, String loginToken) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("userId", userId);
        paramsMap.put("loginToken", loginToken);
        String body = HttpUtil.post(cacSignUrl, paramsMap);
        return JSONObject.parseObject(body);
    }
}
