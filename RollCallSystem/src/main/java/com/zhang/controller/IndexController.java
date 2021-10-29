package com.zhang.controller;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   TestJsController
 * @Time     :   2021/10/29
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/index","/"})
    public String index(){
        return "index";
    }
}
