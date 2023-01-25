package com.shoplive.task.entitiy;

import com.shoplive.task.common.entity.BasicEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
@Setter
@Getter
@RedisHash("test")
public class TestEntity extends BasicEntity {
    String title;
    String description;

    public TestEntity() {
    }

    public TestEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
