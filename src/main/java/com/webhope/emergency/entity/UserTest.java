package com.webhope.emergency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author w.z
 * @date 2019/11/17 21:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;
}
