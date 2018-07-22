//package com.example.demo.config;
//
//import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
//import org.apache.ibatis.reflection.MetaObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Date;
//
///**
// *  注入公共字段自动填充,任选注入方式即可
// */
////@Component
//public class MyMetaObjectHandler extends MetaObjectHandler {
//
//    protected final static Logger logger = LoggerFactory.getLogger(MyMetaObjectHandler.class);
//
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        setFieldValByName("createAt",new Date(),metaObject);
//        setFieldValByName("updateAt",new Date(),metaObject);
//        setFieldValByName("id", UniqueDBIndexUtil.generate(),metaObject);
//        logger.info("新增的时候干点不可描述的事情");
//    }
//
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        setFieldValByName("updateAt",new Date(),metaObject);
//        logger.info("更新的时候干点不可描述的事情");
//    }
//
//}
