package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 2019/10/3010:09
 * <p>
 * 未知的事情 永远充满变数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer role_id;
    private String role_name;
    private String remark;
    private String create_user_id;
    private Date create_time;


}
