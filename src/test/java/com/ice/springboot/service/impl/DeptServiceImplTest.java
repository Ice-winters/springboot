package com.ice.springboot.service.impl;

import com.ice.springboot.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: Ice-winters
 * @Date: 2019/5/18 21:09
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceImplTest {


    @Autowired
    private DeptService deptService;

    @Test
    public void testList(){
        deptService.list().forEach(dept -> System.out.println(dept.toString()));
    }
}