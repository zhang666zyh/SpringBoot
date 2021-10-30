package com.zhang.controller;
// @CharacterEncoding   :   UTF-8
/*
 * @File     :   ExportToExcelController
 * @Time     :   2021/10/30
 * @Author   :   张宇航
 * @Contact  :   zhangzyh666@163.com
 * @MyWeb    :   https://zhang666zyh.github.io
 */

import com.zhang.pojo.Student;
import com.zhang.service.StudentService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ExportToExcelController {

    @Autowired
    public StudentService studentService;

    @RequestMapping("/exportToExcel")
    private void getExcel(HttpServletResponse response) throws IOException {
        String fileName = "20级华为创新版学生信息表.xls";
        response.setContentType("application/excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ";filename*=utf-8''" + URLEncoder.encode(fileName, "UTF-8"));
        response.flushBuffer();
        List<Student> studentList = studentService.getStudentList();
        String aa = "sheet";
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        int rowNum = 0;
// 添加标题
        String[] headers = {"id", "姓名", "学号","身份证号","性别","生日"};
        HSSFRow row = sheet.createRow(rowNum);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
//添加数据
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        while(true){
            for (int i = 0;i < studentList.size();i++) {
                rowNum++;
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(studentList.get(i).getId());
                row1.createCell(1).setCellValue(studentList.get(i).getName());
                row1.createCell(2).setCellValue(studentList.get(i).getSchoolNumber());
                row1.createCell(3).setCellValue(studentList.get(i).getIdCard());
                row1.createCell(4).setCellValue(studentList.get(i).getSex());
                row1.createCell(5).setCellValue(simpleDateFormat.format(studentList.get(i).getBirthday()));

            }
            if(rowNum == studentList.size()){
                break;
            }
        }
        workbook.write(response.getOutputStream());
        workbook.close();
    }

}
