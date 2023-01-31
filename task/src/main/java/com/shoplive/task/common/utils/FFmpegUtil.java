package com.shoplive.task.common.utils;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class FFmpegUtil {
    private FFmpeg fFmpeg;
    private FFprobe fFProbe;
    @Value("${upload.path}")
    private String uploadUrl;
    @Value("${upload.convert.path}")
    private String convertPath;
    @Value("${upload.thumbnail.path}")
    private String thumbnailPath;

    public FFmpegProbeResult getProbeResult(String filePath) {
        
        FFmpegProbeResult ffmpegProbeResult = null;

        try {

            ffmpegProbeResult = fFProbe.probe(uploadUrl.concat(filePath));

        } catch (IOException e) {
            System.out.println("[ERROR] FFmpegUtil.getProbeResult() :: " + e.getMessage());
        }

        return ffmpegProbeResult;
    }

    public void convertVideo(String fileName, String format, int width, int height) {
        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(uploadUrl.concat(fileName))
                .overrideOutputFiles(true)
                .addOutput(convertPath.concat(fileName))
                .setFormat(format)
                .setVideoResolution(width, height)
                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
                .done();

        FFmpegExecutor executable = new FFmpegExecutor(fFmpeg, fFProbe);
        FFmpegJob job = executable.createJob(builder);
        System.out.println("CONVERTING START!");
        job.run();

        if (job.getState() == FFmpegJob.State.FINISHED) {
            System.out.println("SUCCESS CONVERTING!");
        }
    }

    public void createThumbnail(String fileName) {
        String thumbnailName = fileName.substring(0, fileName.lastIndexOf(".")).concat(".png");

        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(uploadUrl + fileName)
                .overrideOutputFiles(true)
                .addExtraArgs("-ss", "00:00:01")
                .addOutput(thumbnailPath + thumbnailName)
                .setFrames(1)
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(fFmpeg, fFProbe);
        executor.createJob(builder).run();

        System.out.println("SUCCESS MAKING THUMBNAIL!");

    }

}
