package com.shoplive.task.controller.video;

import com.shoplive.task.common.response.ApiResponse;
import com.shoplive.task.common.validator.multipart.MultipartFileValidator;
import com.shoplive.task.entitiy.video.VideoEntity;
import com.shoplive.task.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private MultipartFileValidator validator;

    /**
     * method : POST
     * uri : /video/save
     * description : 영상 저장
     * @Param : file (영상 파일)
     * @Param : fileName (영상 파일명)
     * */
    @PostMapping(value = "/save")
    public ApiResponse saveVideo(@Valid @RequestParam("file") MultipartFile file,
                                    @Valid @RequestParam("fileName") String fileName) {
        validator.isValid(file);
        videoService.save(file, fileName);
        return ApiResponse.ok();
    }

    /**
     * method : GET
     * uri : /video/{id}
     * description : 영상 상세 조회
     * @Param : id
     * */
    @GetMapping(value = "/{id}")
    public ApiResponse<Optional<VideoEntity>> getVideoById(@Valid @PathVariable String id) {
        return ApiResponse.ok(videoService.getById(id));
    }
}