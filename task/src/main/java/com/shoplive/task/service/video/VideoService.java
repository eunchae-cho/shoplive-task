package com.shoplive.task.service.video;

import com.shoplive.task.common.enums.ErrorCode;
import com.shoplive.task.common.exception.CustomException;
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
    private final static String UPLOAD = "/static/upload/";
    private final static String CONVERT = "/static/upload/convert/";

    public List<VideoEntity> getAll() {
        return (List<VideoEntity>) videoRepository.findAll();
    }

    public void save(MultipartFile file, String fileName) {
        try {

            if (file.isEmpty()) { return; }

            // 파일 이름 url 만들기
            String pathName = uploadUtil.makePath(file, fileName);

            // 영상 업로드
            uploadUtil.upload(file, pathName);

            // 영상 정보 가져오기
            FFmpegProbeResult ffmpegProbeResult = fmpegUtil.getProbeResult(pathName);

            // 썸네일 저장
            fmpegUtil.createThumbnail(pathName);

            // 영상 리사이즈
            int width = 360;
            int height = 240;
            fmpegUtil.convertVideo(pathName, "mp4", width, height);

            VideoInfo original = new VideoInfo(
                    file.getSize(),
                    String.valueOf(ffmpegProbeResult != null ? ffmpegProbeResult.getStreams().get(0).width : ""),
                    String.valueOf(ffmpegProbeResult != null ? ffmpegProbeResult.getStreams().get(0).height : ""),
                    UPLOAD + pathName
            );

            VideoInfo resized = new VideoInfo(
                    file.getSize(),
                    String.valueOf(width),
                    String.valueOf(height),
                    CONVERT + pathName
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
            throw new CustomException(ErrorCode.BAD_REQUEST, e.getMessage());
        }
    }

    public Optional<VideoEntity> getById(String id) {
        return videoRepository.findById(id);
    }

}