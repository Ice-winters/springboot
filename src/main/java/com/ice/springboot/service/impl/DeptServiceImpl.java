package com.ice.springboot.service.impl;

import com.ice.springboot.dao.DeptMapper;
import com.ice.springboot.service.DeptService;
import com.ice.springboot.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Ice-winters
 * @Date: 2019/5/18 21:04
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
