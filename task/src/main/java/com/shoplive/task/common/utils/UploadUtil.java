package com.shoplive.task.common.utils;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UploadUtil {
    @Value("${upload.path}")
    private String uploadUrl;

    public String makePath(MultipartFile file, String fileName) {
        String fileFormat = file.getContentType().split("/")[1];
        return UUID.randomUUID() + "_" + fileName + "." + fileFormat;
    }

    public void upload(MultipartFile file, String path) {
        try {
            String uploadPath = uploadUrl.concat(path);
            System.out.println("upload path :: " + uploadPath);

            file.transferTo(new File(uploadPath));
            System.out.println("SUCCESS UPLOAD!");

        } catch (IOException e) {
            System.out.println("[ERROR] UploadUtils.upload() :: " + e.getMessage());
        }
    }
}
