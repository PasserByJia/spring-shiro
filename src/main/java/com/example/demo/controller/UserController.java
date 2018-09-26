package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.util.Common;
import com.example.demo.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController extends BasicController {
    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
    public Map<String, Object> changePassword(@RequestBody Map map){
        String newPassword = (String)map.get("password");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findByUsername(username);
        user.setPassword(newPassword);
        try{
            userService.update(user,username);
        }catch (Exception e){
           return ResponseUtil.errorResponse(Common.Error_500,"修改密码失败",null);
        }
        return ResponseUtil.successResponse(Common.Error_001,"修改密码成功请重新登录");
    }
}
