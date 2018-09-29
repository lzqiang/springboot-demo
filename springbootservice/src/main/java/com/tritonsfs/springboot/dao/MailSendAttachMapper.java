package com.tritonsfs.springboot.dao;


import com.tritonsfs.cac.frame.dao.MapperProvider;
import com.tritonsfs.springboot.model.MailSendAttach;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MailSendAttachMapper {
    @Select("select * from mail_send_attach where id = #{id} ")
    MailSendAttach queryById(@Param("id") String id);

    @SelectProvider(type = MapperProvider.class, method = "queryByEntity")
    List<MailSendAttach> queryByEntity(MailSendAttach mailSendAttach);

    @SelectProvider(type = MapperProvider.class, method = "queryByEntityOrder")
    List<MailSendAttach> queryByEntityOrder(MailSendAttach mailSendAttach, String... order);

    @InsertProvider(type = MapperProvider.class, method = "insertEntity")
    int insert(MailSendAttach mailSendAttach);

    @InsertProvider(type = MapperProvider.class, method = "insertBatch")
    int insertBatch(@Param("list") List<MailSendAttach> list);

    @UpdateProvider(type = MapperProvider.class, method = "updateEntity")
    int update(MailSendAttach mailSendAttach);

    @DeleteProvider(type = MapperProvider.class, method = "deleteEntity")
    int delete(MailSendAttach mailSendAttach);
}