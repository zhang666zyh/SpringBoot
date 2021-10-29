package com.zhang.controller;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   SendDataToMySqlController
 * @Time     :   2021/10/29
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import com.zhang.pojo.Student;
import com.zhang.mapper.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

@Controller
public class SendDataToMySqlController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/sendDataToMySqlController")
    @ResponseBody
    public void sendDataToMySqlController(@RequestBody String data) {
        String[] datas = data.split("=", 3);
        int id = Integer.parseInt(StringUtils.substringBefore(datas[1],"n"));
        String name = StringUtils.substringBefore(datas[2],"s");
        String state = datas[2].substring(datas[2].indexOf("=") + 1);

        Student student = new Student(id,name,state);
        studentService.addStudent(student);
    }
}