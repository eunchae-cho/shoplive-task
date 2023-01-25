package com.shoplive.task.common.validator.multipart;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class MultipartFileSizeValidator implements ConstraintValidator<MultipartFileSizeValid, List<?>> {

    private static final String ERROR_MSG = "파일 용량이 100MB를 초과하였습니다.";
    private static final long FILE_SIZE = 100 * 1024 * 1024L;

    @Override
    public boolean isValid(List<?> value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(ERROR_MSG).addConstraintViolation();

        for (Object file: value) {
            if (((MultipartFile) file).getSize() > FILE_SIZE) {
                return false;
            }
        }

        return true;
    }
}
