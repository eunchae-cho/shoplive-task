package com.shoplive.task.entitiy.video;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoInfo {
    private Long fileSize;
    private String width;
    private String height;
    private String videoUrl;
}
