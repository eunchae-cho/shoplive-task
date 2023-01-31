package com.shoplive.task.config;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FFmpegConfig {

    @Value("${ffmpeg.exe.location}")
    private String ffmpegLocation;

    @Value("${ffprobe.exe.location}")
    private String ffprobeLocation;

    @Bean(name = "fFmpeg")
    public FFmpeg fFmpeg() throws IOException {
        return new FFmpeg(ffmpegLocation);
    }

    @Bean(name = "fFprobe")
    public FFprobe fFprobe() throws IOException {
        return new FFprobe(ffprobeLocation);
    }
}
