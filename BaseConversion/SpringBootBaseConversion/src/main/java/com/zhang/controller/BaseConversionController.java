package com.zhang.controller;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   BaseConversion
 * @Time     :   2021/10/25
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class BaseConversionController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/calculate")
    public String caculate(@RequestParam("beforeValue")String beforeValue, @RequestParam("beforeBase")String beforeBase, @RequestParam("afterBase")String afterBase, Model model){
        if(beforeValue == null || beforeBase == null || afterBase == null){
            model.addAttribute("error","输入项不能为空");
            return "redirect:/index";
        }else{
            BigInteger bigInteger = new BigInteger(beforeValue,Integer.parseInt(beforeBase));
            String afterValue = bigInteger.toString(Integer.parseInt(afterBase));
            model.addAttribute("afterValue",afterValue.toUpperCase());
            return "index";
        }
    }
}
