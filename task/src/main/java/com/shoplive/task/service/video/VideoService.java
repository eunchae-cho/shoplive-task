package com.shoplive.task.service.video;

import com.shoplive.task.common.utils.UploadUtils;
import com.shoplive.task.entitiy.video.VideoEntity;
import com.shoplive.task.entitiy.video.VideoInfo;
import com.shoplive.task.repository.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public List<VideoEntity> getAll() {
        return (List<VideoEntity>) videoRepository.findAll();
    }

    public void save(MultipartFile file, String fileName) {
        try {

            if (file.isEmpty()) { return; }

            String uploadPath = UploadUtils.makePath(file, fileName);
            System.out.println("upload path :: " + uploadPath);

            file.transferTo(new File(uploadPath));
            System.out.println("파일 업로드 성공!");

            VideoInfo videoInfo = new VideoInfo(
                    file.getSize(),
                    "",
                    "",
                    uploadPath
            );

            VideoEntity videoEntity = new VideoEntity(
                    fileName,
                    videoInfo,
                    new VideoInfo(),
                    LocalDateTime.now()
            );

            videoRepository.save(videoEntity);

        } catch (Exception e) {
            System.out.println("[ERROR] videoService save() ::" + e.getMessage());
        }
    }

}
