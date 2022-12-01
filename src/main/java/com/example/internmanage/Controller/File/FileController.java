package com.example.internmanage.Controller.File;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

//上传不要用@Controller,用@RestController
@RestController
public class FileController {
    private static final String URL = "C:/uploadFiles/";
    //文件上传
    @PostMapping("/file/upload")
    public String file(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());//文件名
        System.out.println(file.getContentType());//文件类型
        System.out.println(file.getSize());//文件大小
        System.out.println(file.getInputStream());//文件的输入流

        //获得文件上传的路径
//        String path = ResourceUtils.getURL("classpath:").getPath()+"static/files/";
        String path = URL;
        System.out.println(path);
        java.io.File newFile=new java.io.File(path);//由于自定义的实体类和java.io.File重名
        //文件夹不存在则重建
        if(!newFile.exists()){
            newFile.mkdirs();
        }
        //上传
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());//mysql中的日期格式
        System.out.println(time);
        String fileName=date.getTime()+file.getOriginalFilename();
        System.out.println(fileName);
        file.transferTo(new java.io.File(newFile,fileName));
        //将文件上传的url存入数据表中
        System.out.println("文件上传成功");

        return fileName;
    }

    //文件的下载
    @GetMapping("/file/download")
    public String fileDownload(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String url = request.getParameter("url");
        url=URL+url;
        //获得输入流
        FileInputStream inputStream = new FileInputStream(new java.io.File(url));
        // 设置响应头、以附件形式打开文件
//        response.setHeader("content-disposition", "attachment; fileName=" + file.getFileName());
        //获得输出流对象
        ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);
        }
        outputStream.close();
        inputStream.close();
        return "downloadSuccess";
    }


}

