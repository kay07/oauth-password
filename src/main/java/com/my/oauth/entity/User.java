package com.my.oauth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kay
 * @date 2021/12/14
 */
@Data
public class User implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String role;
    private String authorize;
}
