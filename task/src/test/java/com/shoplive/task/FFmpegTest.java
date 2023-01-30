package com.shoplive.task;

import com.shoplive.task.common.utils.FFmpegUtil;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFmpegUtils;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class FFmpegTest {

    final String ffmpegUrl = System.getProperty("user.dir").concat("/src/main/resources/ffmpeg/bin/ffmpeg");
    final String ffprobeUrl = System.getProperty("user.dir").concat("/src/main/resources/ffmpeg/bin/ffprobe");
    final String inputResource = System.getProperty("user.dir").concat("/src/main/resources/static/upload/happyNewYear.mp4");
    final String outputUrl = System.getProperty("user.dir").concat("/src/main/resources/static/upload/convert/test.mp4");

    @Autowired
    private FFmpegUtil fFmpegUtil;

    @Test
    public void convertTest() throws IOException {
//        FFmpeg fFmpeg = new FFmpeg(ffmpegUrl);
//        FFprobe fFprobe = new FFprobe(ffprobeUrl);
//
//        FFmpegBuilder builder = new FFmpegBuilder().setInput(inputResource)
//                .overrideOutputFiles(true)
//                .addOutput(outputUrl)
//                .setFormat("mp4")
//                .disableSubtitle()
//                .setVideoResolution(360, 240)
//                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
//                .done();
//
//        FFmpegExecutor executor = new FFmpegExecutor(fFmpeg, fFprobe);
//        executor.createJob(builder).run();
    }

    @Test
    public void getProbeTest(){
//        fFmpegUtil.getProbeResult("happyNewYear.mp4");

    }

}
