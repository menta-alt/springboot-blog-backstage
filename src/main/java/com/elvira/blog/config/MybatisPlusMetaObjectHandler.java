package com.elvira.blog.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
//        this.setFieldValByName("createBy", CookieUtil.getLoginUser(),metaObject);
        this.setFieldValByName("createTime", new Date(),metaObject);
//        this.setFieldValByName("updateBy", CookieUtil.getLoginUser(),metaObject);
//        this.setFieldValByName("updateTime", new Date(),metaObject);
//        this.setFieldValByName("version", Long.valueOf(1),metaObject);
//        this.setFieldValByName("appSecret", UUID.randomUUID().toString().replaceAll("-",""),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName("updateBy", CookieUtil.getLoginUser(),metaObject);
//        this.setFieldValByName("updateTime", new Date(),metaObject);
//        this.setFieldValByName("version", this.getFieldValByName("version",metaObject),metaObject);
    }
}
