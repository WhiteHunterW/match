package com.webhope.emergency.dao;

import com.webhope.emergency.entity.UserTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author w.z
 * @date 2019/11/17 21:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserTestDaoTest {
    
    @Autowired
    private UserTestDao userTestDao;
    @Test
    void queryByName() {
        UserTest userTest = userTestDao.queryByName("wenzeng");
        System.out.println(userTest);
    }
}