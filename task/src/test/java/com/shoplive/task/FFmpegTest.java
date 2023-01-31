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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
public class FFmpegTest {
//
//    final String ffmpegUrl = System.getProperty("user.dir").concat("/src/main/resources/ffmpeg/bin/ffmpeg");
//    final String ffprobeUrl = System.getProperty("user.dir").concat("/src/main/resources/ffmpeg/bin/ffprobe");
//    final String inputResource = System.getProperty("user.dir").concat("/src/main/resources/static/upload/happyNewYear.mp4");
//    final String outputUrl = System.getProperty("user.dir").concat("/src/main/resources/static/upload/convert/test.mp4");
//
//    @Autowired
//    private FFmpegUtil fFmpegUtil;
//
//    @Test
//    public void convertTest() throws IOException {
////        FFmpeg fFmpeg = new FFmpeg(ffmpegUrl);
////        FFprobe fFprobe = new FFprobe(ffprobeUrl);
////
////        FFmpegBuilder builder = new FFmpegBuilder().setInput(inputResource)
////                .overrideOutputFiles(true)
////                .addOutput(outputUrl)
////                .setFormat("mp4")
////                .disableSubtitle()
////                .setVideoResolution(360, 240)
////                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
////                .done();
////
////        FFmpegExecutor executor = new FFmpegExecutor(fFmpeg, fFprobe);
////        executor.createJob(builder).run();
////
////
////        String command = "/Users/eunchaecho/dev/shoplive-task/task/src/main/resources/ffmpeg/bin/ffprobe -i -progress "
////                + outputUrl;
////        Process process = Runtime.getRuntime().exec(command);
////        System.out.println(command);
////
////        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
////
////        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
////
////        String s = null;
////        while ((s = stdInput.readLine()) != null) {
////            System.out.println(s);
////        }
////
////        while ((s = stdError.readLine()) != null) {
////            System.out.println(s);
////        }
//    }
}
