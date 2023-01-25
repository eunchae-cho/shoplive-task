package com.shoplive.task.common.entity;

import org.springframework.data.annotation.Id;

public abstract class BasicEntity {
    @Id
    String id = null;
}
