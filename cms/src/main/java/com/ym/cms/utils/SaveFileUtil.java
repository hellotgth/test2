package com.ym.cms.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class SaveFileUtil {
    public static String saveFile(MultipartFile pic) {
            String path = "d:/file";
            String Imageurl = "";
            File file = new File(path, pic.getOriginalFilename());
            try {
                //储存图片
                pic.transferTo(file);
                Imageurl = "http://127.0.0.1:8080/cms/upload/" + pic.getOriginalFilename();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Imageurl;

    }
}