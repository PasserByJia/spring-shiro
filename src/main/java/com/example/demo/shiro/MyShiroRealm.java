package com.example.demo.shiro;

import com.example.demo.domain.Resources;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author Fujt
 * @description
 * @date 16:09 2018/5/13
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 认证信息(身份验证) Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户的输入帐号
        String username = (String) token.getPrincipal();
        //System.out.println(token.getCredentials());
        // 通过username从数据库中查找 User对象，如果找到，没找到.
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByUsername(username);

        if (user == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), // 用户名
                user.getPassword(), // 密码
                getName() // realm name
        );
        return authenticationInfo;
    }

    //获取权限

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String)principals.getPrimaryPrincipal();
        User user = userService.findByUsername(username);
        for (Role role : user.getRole()) {

            authorizationInfo.addRole(role.getName());

            for (Resources resource : role.getResources()) {
                authorizationInfo.addStringPermission(resource.getPerssion_code());
            }
        }
        return authorizationInfo;
    }

}

