package com.zhang.controller;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   LogoutController
 * @Time     :   2021/10/30
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/index";
    }
}
