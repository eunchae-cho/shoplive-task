package com.shoplive.task.controller.web;

import com.shoplive.task.entitiy.video.VideoEntity;
import com.shoplive.task.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private VideoService videoService;

    /**
     * method : GET
     * uri : /video
     * description : 영상 목록
     * */

    @GetMapping("/")
    public String video(Model model) {
        List<VideoEntity> videoList = videoService.getAll();
        model.addAttribute("videoList", videoList);
        model.addAttribute("test", "테스트입니다.");
        return "views/video";
    }
}
