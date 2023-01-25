package com.shoplive.task.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class UploadUtils {
    private static final String UPLOAD_URL = "/src/main/resources/static/upload/";
    public static String makePath(MultipartFile file, String fileName) {
        String fileFormat = file.getContentType().split("/")[1];
        return System.getProperty("user.dir").concat(UPLOAD_URL).concat(UUID.randomUUID() + "_" + fileName + "." + fileFormat);
    }
}
