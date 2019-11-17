package com.webhope.emergency.dao;

import com.webhope.emergency.entity.UserTest;

/**
 * @author w.z
 * @date 2019/11/17 21:18
 */
public interface UserTestDao {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    UserTest queryByName(String username);
}
