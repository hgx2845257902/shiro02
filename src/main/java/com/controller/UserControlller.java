package com.controller;

import com.model.User;
import com.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Security;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserControlller {

    @Autowired
    private IUserService userService;

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }


    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        String msg="";
        int code=1;
        Map<String,Object> map=new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            List<User> users = userService.listAll(user);
            session.setAttribute("users",users);
            subject.login(token);
        }
//        catch (UnknownAccountException e) {
//            msg="账号不存在";
//            code=-1;
//        }
        catch (IncorrectCredentialsException e){
            msg="密码错误";
            code=0;
        }
        catch (AuthenticationException e){
            msg="请输入正确的账号、密码，或者账号不存在";
            code=-2;
        }
        map.put("code",code);
        map.put("msg",msg);
        session.setAttribute("map",map);
        if(code<1){
            return "login";
        }else{
            return "main";
        }
    }




}
