package com.zhang.mapper;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   StudentService.xml
 * @Time     :   2021/10/29
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import com.zhang.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentService {
    void addStudent(Student student);
    List<Student> getStudentList();
}
