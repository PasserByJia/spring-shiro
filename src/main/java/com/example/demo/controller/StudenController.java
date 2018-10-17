package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.util.Common;
import com.example.demo.util.ResponseUtil;
import net.bytebuddy.description.type.TypeDefinition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudenController extends BasicController{
    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    public Map<String,Object> getStudent( @RequestParam(value = "pageNum") Integer page,
                                          @RequestParam(value = "pageSize") Integer size){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Map<String, Object> map = new HashMap<String, Object>();
        Page list = studentService.findAllPagebleT(PageRequest.of(page-1, size, sort), "Student");  //这个PageRequest咋回事?
        map.put("total", list.getTotalElements());
        map.put("rows", list.getContent());
        return ResponseUtil.successResponse(map);
    }

}
