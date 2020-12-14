package com.example.demo.controller;

import com.example.demo.exception.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 定制返回的json数据
 */
@ControllerAdvice
public class MyExceptionHandler {
   /* @ResponseBody
    @ExceptionHandler(UserNotExitException.class)
    public Map<String,Object> handleException (Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/
   @ExceptionHandler(UserNotExitException.class)
   public String handleException (Exception e,HttpServletRequest request ) {
       Map<String, Object> map = new HashMap<>();
       //设置错误状态码
       request.setAttribute("javax.servlet.error.status_code",500);
       map.put("code", "user.notexist");
       map.put("message", e.getMessage());
       request.setAttribute("ext",map);
       //转发
       return "forward:/error";
   }


}
