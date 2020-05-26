package com.jack.fiveyearcar.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class ResultUtil {

    public static String success(String code,String msg, Object data){
        HashMap<String, Object> resultMap = new HashMap<>(8);
        resultMap.put("code",code);
        resultMap.put("msg",msg);
        resultMap.put("data", data);
        String json = JSON.toJSONString(resultMap);
        return json;
    }
}
