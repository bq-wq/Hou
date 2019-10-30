package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 2019/10/2911:09
 * <p>
 * 未知的事情 永远充满变数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String status;
    private Integer create_user_id ;
    private Date create_time;
    private Integer dept_id;
    private String sex;
    private  String lockdate;
    private String salt;




}
