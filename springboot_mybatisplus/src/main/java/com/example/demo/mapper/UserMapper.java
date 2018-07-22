package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.ws.soap.MTOM;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2018-07-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
