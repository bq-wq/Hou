package com.qf.controller;

import com.qf.pojo.User;
import com.qf.pojo.UserVo;
import com.qf.service.UserService;
import com.qf.utils.Captcha1;
import com.qf.utils.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * 2019/10/2911:28
 * <p>
 * 未知的事情 永远充满变数
 */
@Controller
@RequestMapping("/sys")
@CrossOrigin("http://localhost:8088")
public class SysController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public R login(@RequestBody UserVo  user,HttpSession session,HttpServletRequest req,HttpServletResponse res) throws IOException {
//        Captcha1.generateCaptcha(req,res);

        Integer captcha =(Integer) session.getAttribute("captcha");
        System.out.println("系统生成："+captcha);
        System.out.println("前端传来："+user.getCaptcha());
        System.out.println("登入前边传来参数："+user);
        //获取subject 调用login
        Subject subject = SecurityUtils.getSubject();
        //创建 登入 delingpai
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        System.out.println(token);


        if(captcha!=Integer.parseInt(user.getCaptcha()) ){
            return R.error("验证码错误！");
        }
        subject.login(token);
        return R.ok();
    }
    @RequestMapping("/test2")
    public void test2(HttpSession session, HttpServletResponse res, HttpServletRequest req) throws IOException {
        Captcha1.generateCaptcha(req, res);
    }


    //显示顶部欢迎名称
    @RequestMapping("/user/info")
    @ResponseBody
    private R user(){

        Object username1 = SecurityUtils.getSubject().getPrincipal();
        String username = (String) username1;
        User user = userService.queryUsername(username);
        return R.ok().put("user", user);
    }

    //显示左侧菜单栏
    @RequestMapping("/menu/user")
    @ResponseBody
    private R user1(){
        //  查询用户权限和菜单信息
        Object username1 = SecurityUtils.getSubject().getPrincipal();
        String username = (String) username1;

        List<String> list = userService.queryByUsername(username);



        return R.ok().put("menuList", list);
    }



}
