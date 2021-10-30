package com.zhang.pojo;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   Student
 * @Time     :   2021/10/29
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String schoolNumber;
    private String IdCard;
    private String sex;
    private Date birthday;
}
