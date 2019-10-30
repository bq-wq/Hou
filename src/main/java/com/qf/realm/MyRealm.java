package com.qf.realm;

import com.qf.pojo.User;
import com.qf.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 2019/10/2911:40
 * <p>
 * 未知的事情 永远充满变数
 */
@Setter
public class MyRealm extends AuthorizingRealm {

    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {



        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        //获取用户登入发来的用户名
        String username = (String) Token.getPrincipal();
        System.out.println("-------"+username);

        User user  = userService.queryUsername(username);
        //判断用户信息是否为空
        if(user==null){
            return null;
        }
        System.out.println("用户信息："+user);
        //将用户信息封装在  AuthenticationInfo中
     /*   return new SimpleAuthenticationInfo(user.getUsername(),//数据库中用户名
                                     user.getPassword(), //数据库中的密码
                                     this.getName());// realm的标识
*/
        return new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                this.getName());
    }

}
