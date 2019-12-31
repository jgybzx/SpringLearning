package com.jgybzx.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author: guojy
 * @date: 2019/12/30 15:13
 * @Description: ${TODO}
 * @version:
 */
@Controller
public class FileUploadController {
    @RequestMapping("/fileupload")
    public String demo1(MultipartFile fileupload, HttpServletRequest request) {
        System.out.println("访问成功");
        try {
            //获取当前日期
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formatdate = simpleDateFormat.format(date);

            //在项目跟目录下创建文件夹，存放上传的文件,并且将时间作为每一层子文件夹
            String realPath = request.getSession().getServletContext().getRealPath("/upload/" + formatdate);
            System.out.println(realPath);
            File fatherfile = new File(realPath);
            if (!fatherfile.exists()){
                fatherfile.mkdirs();
            }

            //随机字符
            String uuid = UUID.randomUUID().toString().replace("-", "");
            //获取文件名字
            String originalFilename = fileupload.getOriginalFilename();
            //拼接文件名字
            String filename = uuid+originalFilename;
            //创建文件，父路径/文件名字

            File file  = new File(fatherfile+"/"+filename);

            fileupload.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
