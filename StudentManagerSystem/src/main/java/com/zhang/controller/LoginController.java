package com.zhang.controller;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   LoginController
 * @Time     :   2021/10/29
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import com.zhang.pojo.Admin;
import com.zhang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    public LoginService loginService;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession httpSession){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            model.addAttribute("loginResult","用户名或密码不能为空");
            return "index";
        }

        int flag = 0;
        List<Admin> adminList = loginService.getAdminList();
        for(Admin admin : adminList){
            if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
                flag += 1;
            }
        }

        if(flag == 0){
            model.addAttribute("loginResult","用户名或密码错误");
            return "index";
        }else{
            httpSession.setAttribute("loginedUsername",username);
            return "redirect:/main";
        }
    }
}
