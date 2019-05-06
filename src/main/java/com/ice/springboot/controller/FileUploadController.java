package com.ice.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/file/upload")
    public String handleFormUpload(String name, MultipartFile[] files,
                                    @RequestParam(name = "path" ,required = false) String path) throws IOException {

        for (MultipartFile file : files){
            String originalFilename = file.getOriginalFilename();
            System.out.println("file name is :" + originalFilename);
            file.transferTo(new File("D:/myfiles"+"/"+originalFilename));
        }
        return path;
    }
}
