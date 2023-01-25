package com.shoplive.task.entitiy.video;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VideoInfo {
    private Long fileSize;
    private String width;
    private String height;
    private String videoUrl;
}
