package com.my.oauth.service;

import com.my.oauth.entity.User;
import com.my.oauth.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kay
 * @date 2021/12/14
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.byUserName(username);
        UserDetails userDetails= org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .authorities(user.getAuthorize())//可以是多个，多个的话逗号分开即可
                .build();
        return userDetails;
    }
}
