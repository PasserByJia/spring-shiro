package com.example.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerssionTestController extends BasicController{

    @RequiresPermissions("per1")
    @RequestMapping(value = "/per1",method = RequestMethod.GET)
    public String per1(){
        return "per1:success";
    }

    @RequiresPermissions("per2")
    @RequestMapping(value = "/per2",method = RequestMethod.GET)
    public String per2(){
        return "per2:success";
    }

    @RequiresPermissions("per3")
    @RequestMapping(value = "/per3",method = RequestMethod.GET)
    public String per3(){
        return "per3:success";
    }

    @RequiresPermissions("per4")
    @RequestMapping(value = "/per4",method = RequestMethod.GET)
    public String per4(){
        return "per4:success";
    }
}
