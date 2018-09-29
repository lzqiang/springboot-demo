package com.tritonsfs.springboot.service;

import com.tritonsfs.springboot.dao.MailSendAttachMapper;
import com.tritonsfs.springboot.model.MailSendAttach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 2018/9/28 19:34 by 刘赵强
 **/

@Service
public class MailSendService {
    @Autowired
    private MailSendAttachMapper mailSendAttachMapper;

    /**
     * 同一个类中  如果方法A没有事务，调用方法B有事务，时不会生效
     */
    public void testA() {
        testB();
    }
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRES_NEW)
    public void testB() {
        MailSendAttach mailSendAttach = new MailSendAttach();
        mailSendAttach.setId(String.valueOf(System.currentTimeMillis()));
        mailSendAttachMapper.insert(mailSendAttach);
        int i = 1/0;
    }
}
