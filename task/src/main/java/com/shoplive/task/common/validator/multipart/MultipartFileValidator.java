package com.shoplive.task.common.validator.multipart;

import com.shoplive.task.common.exception.CustomException;
import com.shoplive.task.common.enums.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class MultipartFileValidator {
    private static final String INVALID_SIZE = "파일 용량이 100MB를 초과하였습니다.";
    private static final long FILE_SIZE = 100 * 1024 * 1024L;
    private static final String INVALID_FORMAT = ".mp4 확장자만 가능합니다.";
    private static final String FORMAT = "mp4";

    public void isValid(Object file) {

        if (((MultipartFile) file).getSize() > FILE_SIZE) {
            throw new CustomException(ErrorCode.BAD_REQUEST, INVALID_SIZE);
        }

        if (!((MultipartFile) file).getContentType().endsWith(FORMAT)) {
            throw new CustomException(ErrorCode.BAD_REQUEST, INVALID_FORMAT);
        }
    }
}
