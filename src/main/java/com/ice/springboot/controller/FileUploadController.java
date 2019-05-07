package com.ice.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @PostMapping("/file/upload")
    public String handleFormUpload(String name, MultipartFile[] files,
                                   @RequestParam(name = "path", required = false) String path, Model model) throws IOException {

        File filepath = new File(path);
        boolean result = filepath.exists() || filepath.mkdirs();

//        boolean result = this.createFile(path);

        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            System.out.println("file name is :" + originalFilename);
            if (originalFilename.isEmpty())
                continue;
            file.transferTo(new File(path + "/" + originalFilename));
        }
        System.out.println("dest path is :" + path);

        model.addAttribute("upload_dir", "<b><a>"+path+"</a></b>");
        return "filedir";
    }


    /**
     * 创建多级目录文件
     *
     * @param path 文件路径
     * @throws IOException
     */
    private boolean createFile(String path) throws IOException {
        if (!StringUtils.isEmpty(path)) {
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.mkdir();
//            file.createNewFile();
        }
        return true;
    }
}
