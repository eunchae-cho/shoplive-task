package com.shoplive.task.controller.video;

import com.shoplive.task.common.utils.UploadUtils;
import com.shoplive.task.common.validator.multipart.MultipartFileCustom;
import com.shoplive.task.entitiy.video.VideoEntity;
import com.shoplive.task.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * method : GET
     * uri : /video
     * description : 영상 목록 조회
     * */
    @GetMapping()
    public ResponseEntity<List<VideoEntity>> getAll() {
        List<VideoEntity> videoList = videoService.getAll();
        return new ResponseEntity(videoList, HttpStatus.OK);
    }

    /**
     * method : POST
     * uri : /video/save
     * description : 영상 저장
     * */
    @PostMapping(value = "/save")
    public ResponseEntity saveVideo(@Valid @RequestParam("file") MultipartFile file,
                                    @Valid @RequestParam("fileName") String fileName) {
        videoService.save(file, fileName);
        return new ResponseEntity(HttpStatus.OK);
    }
}