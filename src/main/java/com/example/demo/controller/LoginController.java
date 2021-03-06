package com.example.demo.controller;

import com.example.demo.domain.Resources;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.util.Common;
import com.example.demo.util.Message;
import com.example.demo.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LoginController extends BasicController{

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public Map<String, Object> login(@RequestBody Map map){
        String username = (String)map.get("username");
        String password = (String)map.get("password");
        //用户身份验证
        UsernamePasswordToken usernamePasswordToken
                = new UsernamePasswordToken(username.trim(), password.trim());

        Subject currentUser = SecurityUtils.getSubject();

        //设置session过期时间为一小时 单位毫秒
        currentUser.getSession().setTimeout(3600000);

        Message message ;

        try {
            if (!currentUser.isAuthenticated()) {
                currentUser.login(usernamePasswordToken);
            }
            message = new Message("success");
        } catch (UnknownAccountException | IncorrectCredentialsException uae) {
            return ResponseUtil.successResponse("用户名或密码错误");
        } catch (ExcessiveAttemptsException eae) {
            return ResponseUtil.successResponse("登录次数超过5次，账户被锁定！");
        } catch (AuthenticationException ae) {
            return ResponseUtil.successResponse("登录失败");
        }
        return ResponseUtil.successResponse("success");
    }

    @RequestMapping(value = "/getRes",method = RequestMethod.GET)
    public Map<String,Object> getRes(){
        Map<String, Object> map = new HashMap<String, Object>();
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findByUsername(username);
        map.put("nickname",user.getNickname());
        List<String> meunList = new ArrayList();
        List<String> permissionList = new ArrayList();
        for(Role role:user.getRole()){
            meunList.add(role.getName());
            for(Resources resources:role.getResources()){
                permissionList.add(resources.getPerssion_code());
            }
        }
        map.put("meunList",meunList);
        map.put("permissionList",permissionList);
        return ResponseUtil.successResponse(map);
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Map<String,Object> logout(){
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
        }
        return ResponseUtil.successResponse("");
    }

    //当后台登陆失效后前台会请求一次get方法的login原因不明
    @GetMapping("/login")
    public Map<String,Object> login() {
        return ResponseUtil.errorResponse(Common.Error_001,Common.Error_MSG_001,null);
    }

}
