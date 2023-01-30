package com.shoplive.task.service.video;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoplive.task.common.utils.FFmpegUtil;
import com.shoplive.task.common.utils.UploadUtil;
import com.shoplive.task.entitiy.video.VideoEntity;
import com.shoplive.task.entitiy.video.VideoInfo;
import com.shoplive.task.repository.video.VideoRepository;

import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private UploadUtil uploadUtil;
    @Autowired
    private FFmpegUtil fmpegUtil;
    private final static String UPLOAD = "/upload/";
    private final static String CONVERT = "/upload/convert/";

    public List<VideoEntity> getAll() {
        return (List<VideoEntity>) videoRepository.findAll();
    }

    public void save(MultipartFile file, String fileName) {
        try {

            if (file.isEmpty()) { return; }

            // url 만들기
            String uploadUrl = uploadUtil.makePath(file, fileName);

            // 영상 업로드
            uploadUtil.upload(file, uploadUrl);

            // 영상 정보 가져오기
            FFmpegProbeResult ffmpegProbeResult = fmpegUtil.getProbeResult(uploadUrl);

            // 영상 resize
            int width = 360;
            int height = 240;
            fmpegUtil.convertVideo(uploadUrl, "mp4", width, height);

            VideoInfo original = new VideoInfo(
                    file.getSize(),
                    String.valueOf(ffmpegProbeResult != null ? ffmpegProbeResult.getStreams().get(0).width : ""),
                    String.valueOf(ffmpegProbeResult != null ? ffmpegProbeResult.getStreams().get(0).height : ""),
                    UPLOAD + uploadUrl
            );

            VideoInfo resized = new VideoInfo(
                    file.getSize(),
                    String.valueOf(width),
                    String.valueOf(height),
                    CONVERT + uploadUrl
            );

            VideoEntity videoEntity = new VideoEntity(
                    fileName,
                    original,
                    resized,
                    LocalDateTime.now()
            );

            // 영상 저장
            videoRepository.save(videoEntity);

        } catch (Exception e) {
            System.out.println("[ERROR] videoService save() ::" + e.getMessage());
        }
    }

    public Optional<VideoEntity> getById(String id) {
        return videoRepository.findById(id);
    }

}