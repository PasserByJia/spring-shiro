package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> successResponse(Object o){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("returnCode", Common.SUCCESS_CODE);
        map.put("returnMsg", Common.SUCCESS_MSG);
        map.put("returnData",o);
        return map;
    }

    public static Map<String, Object> successResponse(String code,String msg){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("returnCode", code);
        map.put("returnMsg", msg);
        map.put("returnData",null);
        return map;
    }
    public static Map<String, Object> errorResponse(String code ,String msg ,Object o){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("returnCode", code);
        map.put("returnMsg", msg);
        map.put("returnData",o);
        return map;
    }
}
