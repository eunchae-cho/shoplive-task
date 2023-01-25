package com.shoplive.task.controller.video;

import com.shoplive.task.common.validator.multipart.MultipartFileCustom;
import com.shoplive.task.entitiy.video.VideoEntity;
import com.shoplive.task.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 비디오 목록 전체 조회
     * */
    @GetMapping()
    public ResponseEntity<List<VideoEntity>> getAll() {
        List<VideoEntity> videoList = videoService.getAll();
        return new ResponseEntity(videoList, HttpStatus.OK);
    }

    /**
     * 비디오 저장
     * */
    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity saveVideo(@Valid @RequestParam VideoEntity video,
                                   @Valid @RequestParam MultipartFileCustom file) {
        videoService.save(video, file);
        return new ResponseEntity(HttpStatus.OK);
    }
}
