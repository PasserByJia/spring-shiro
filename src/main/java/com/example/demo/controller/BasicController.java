package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.ResourceService;
import com.example.demo.service.RoleService;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasicController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    StudentService studentService;

}
