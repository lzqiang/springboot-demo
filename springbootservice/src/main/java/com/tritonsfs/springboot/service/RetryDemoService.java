package com.tritonsfs.springboot.service;

import com.tritonsfs.springboot.exception.RetryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author 2018/9/29 14:41 by 刘赵强
 **/
@Service
@Slf4j
public class RetryDemoService {
    private static int i = 1;
    //backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；
    // multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，
    // 如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
    /**
     * 需求重试的方法
     * @return
     */
    @Retryable(value = {RuntimeException.class}, maxAttempts = 4, backoff = @Backoff(delay = 5000, multiplier = 1 ))
    public String retry() {
        log.info("重试测试...");
        i++;
        log.info("i========={}",i);
        RetryException retryException = new RetryException();
        retryException.setCode("9999");
        retryException.setMsg("连接超时");
        throw retryException;
    }

    /**
     * 重试次数过后还是没有成功执行的方法
     * @param e
     * @return
     */
    @Recover
    public String recover(RetryException e) {
        log.info("recover::");
        log.info(e.getMsg());
        return "6";
    }
}