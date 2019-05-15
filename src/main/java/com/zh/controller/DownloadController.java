package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/download")
public class DownloadController {
    // 定义一个文件存储路径
    private static String parentPath = "E:" + File.separator;

    @RequestMapping("/listFiles")
    public String listFiles(Model model) {
        File path = new File(parentPath);
        List<String> list = new ArrayList<>();
        for (File file : path.listFiles()) {
            if(!file.isDirectory())
                list.add(file.getName());
        }
        model.addAttribute("fileList", list);
        return "file/download";
    }

    @RequestMapping("/down/{filename:.+}")
    public String down(HttpServletResponse response, Model model, @PathVariable("filename") String fileName) {
        // 通过输出流，写到客户端，浏览器
        // 1. 获取文件下载名
//        String fileName = "极光.jpg";

        // 2. 构建一个文件对象通过Paths工具类获取一个Path
        Path path = Paths.get(parentPath, fileName);

        // 3. 判断路径是否存在
        if (Files.exists(path)) {
            // 下载
            // 通过response设定响应类型
            // 4. 获取文件后缀
            String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);

            // 5. 设置contentType，只有指定它才能下载
            response.setContentType("application/" + fileSuffix);

            // 6. 添加头信息 对于中文文件名，需要对其使用URL的编码，这里使用UTF-8标识源字符串的格式，即fileName的格式
            try {
                response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // 设置文件长度，不然chrome下载会失败
            File file = new File(parentPath + fileName);
            response.setContentLength((int) file.length());
            // 7. 下载
            try
            {
                Files.copy(path, response.getOutputStream());
                response.getOutputStream().flush();
                model.addAttribute("downloadStatus", fileName + " 下载成功");
            }
            catch (IOException ex) {
                model.addAttribute("downloadStatus", fileName + " 下载失败");
                ex.printStackTrace();
            }
        }

        return "file/downResponse";
    }
}
