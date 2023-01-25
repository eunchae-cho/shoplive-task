package com.shoplive.task.service.video;

import com.shoplive.task.common.validator.multipart.MultipartFileCustom;
import com.shoplive.task.entitiy.video.VideoEntity;
import com.shoplive.task.repository.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public List<VideoEntity> getAll() {
        return (List<VideoEntity>) videoRepository.findAll();
    }

    public void save(VideoEntity video, MultipartFileCustom file) {
        try {

        } catch (Exception e) {
            System.out.println("[ERROR] VideoService add() ::" + e.getMessage());
        }
    }

}
