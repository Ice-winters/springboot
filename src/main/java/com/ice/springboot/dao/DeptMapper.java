package com.ice.springboot.dao;

import com.ice.springboot.vo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Ice-winters
 * @Date: 2019/5/18 20:53
 * @Description:
 */
//@Mapper
@Repository
public interface DeptMapper {
    List<Dept> findAll();

}
