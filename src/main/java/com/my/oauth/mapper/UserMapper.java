package com.my.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.oauth.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author kay
 * @date 2021/12/14
 */
public interface UserMapper extends BaseMapper<User> {
    User byUserName(@Param(value = "username") String username);
}
