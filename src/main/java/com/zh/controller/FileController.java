package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {
    private static String uploadPath = "E:" + File.separator;

    // 入参代表上传的文件
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        // 1.上传到哪里 2. 上传的是什么 3. 上传细节
        // 1.判断是否为空
        if (file != null && !file.isEmpty()) {

            // 2. 获取原文件的文件名
            String originalFilename = file.getOriginalFilename();
            // 3. 去除文件扩展名
            String fileNamePrefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            // 4. 修改文件名为 原文件名+时间戳
            String newFileNamePrefix = fileNamePrefix + new Date().getTime();
            // 5. 得到新文件名
            String newFileName = newFileNamePrefix + originalFilename.substring(originalFilename.lastIndexOf("."));

            // 6. 创建文件对象
            File fileNew = new File(uploadPath + newFileName);


            // 7. 上传
            try {
                file.transferTo(fileNew);
                model.addAttribute("singleUpload", newFileName + "上传成功");

            } catch (IOException e) {
                model.addAttribute("singleUpload", newFileName + "上传失败");
            }
        }

        return "file/uploadStatus";
    }

    @RequestMapping("/upload2")
    public String upload2(@RequestParam("file") MultipartFile[] files, Model model) {
        if (files != null && files.length > 0) {
            Map<String, String> uploadStatus = new HashMap<>();
            for (MultipartFile file : files) {
                // 1.判断是否为空
                if (file != null && !file.isEmpty()) {

                    // 2. 获取原文件的文件名
                    String originalFilename = file.getOriginalFilename();
                    // 3. 去除文件扩展名
                    String fileNamePrefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));
                    // 4. 修改文件名为 原文件名+时间戳
                    String newFileNamePrefix = fileNamePrefix + new Date().getTime();
                    // 5. 得到新文件名
                    String newFileName = newFileNamePrefix + originalFilename.substring(originalFilename.lastIndexOf("."));

                    // 6. 创建文件对象
                    File fileNew = new File(uploadPath + newFileName);

                    model.addAttribute("fileName", newFileName);

                    // 7. 上传
                    try {
                        file.transferTo(fileNew);
                        uploadStatus.put(newFileName, "上传成功");
                        model.addAttribute("uploadStatus", uploadStatus);
                    } catch (IOException e) {
                        uploadStatus.put(newFileName, "上传失败");
                        model.addAttribute("uploadStatus", uploadStatus);
                    }
                }
            }
        }

        return "file/multiUploadResponse";
    }
}
