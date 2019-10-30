package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 2019/10/3010:13
 * <p>
 * 未知的事情 永远充满变数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private Integer menu_id;
    private String parent_id;
    private String name;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private String order_num;
    private List<Menu> list;




}
