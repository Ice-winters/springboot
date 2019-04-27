package com.ice.springboot.vo;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Ice-winters
 * @Date: 2019/4/25 20:57
 * @Description:
 */
@Data
public class Member implements Serializable {

    @NotNull(message = "{member.mid.notnull.error}")
    @Email(message = "{member.mid.email.error}")
    @NotEmpty(message = "{member.mid.notnull.error}")
    private String mid;

    @NotNull(message = "您的年龄不可以为空")/*{member.age.notnull.error}*/
    @Digits(integer = 3 ,fraction = 0,message = "{member.age.digits.error}")
    private Integer age;

    private Double salary;

    private Date birthday;

}
