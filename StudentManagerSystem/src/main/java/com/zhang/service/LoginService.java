package com.zhang.service;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   LoginService
 * @Time     :   2021/10/29
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import com.zhang.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginService {
    List<Admin> getAdminList();
}
