package com.shoplive.task.common.validator.multipart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Getter
public class MultipartFileCustom {
    @MultipartFileSizeValid
    private final MultipartFile file;
}
