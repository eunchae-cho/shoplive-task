package com.shoplive.task.common.validator.multipart;

import javax.validation.Constraint;

@Constraint(validatedBy = MultipartFileSizeValidator.class)
public @interface MultipartFileSizeValid {
}
