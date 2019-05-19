package com.ice.springboot.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: Ice-winters
 * @Date: 2019/5/18 20:38
 * @Description:
 */
@Data
public class Dept implements Serializable {
    private long deptno;
    private String dname;
}
