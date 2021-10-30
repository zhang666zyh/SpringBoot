package com.zhang.controller;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   StudentController
 * @Time     :   2021/10/29
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import com.zhang.pojo.Student;
import com.zhang.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    public StudentService studentService;

    @RequestMapping("/studentList")
    public String studentList(Model model){
        List<Student> studentList = studentService.getStudentList();
        model.addAttribute("studentList",studentList);
        return "stu/list";
    }

    @RequestMapping("/addStudentPage")
    public String addStudentPage(){
        return "/stu/add";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student){
        studentService.addStudent(student);
        return "redirect:/studentList";
    }

    @GetMapping("/getUpdateStudent/{id}")
    public String getUpdateStudent(@PathVariable("id")int id,Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "/stu/update";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(Student student){
        studentService.updateStudent(student);
        return "redirect:/studentList";
    }


    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id")int id){
        studentService.deleteStudent(id);
        return "redirect:/studentList";
    }
}

