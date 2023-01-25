package com.shoplive.task.entitiy.video;

import com.shoplive.task.common.entity.BasicEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@RedisHash("Video")
@NoArgsConstructor
public class VideoEntity extends BasicEntity {
    @NotBlank(message = "파일명은 필수입니다.")
    private String title;
    private VideoInfo original;
    private VideoInfo resized;
    private LocalDateTime createdAt;
}
