package com.music.controller;


import com.music.pojo.Music;
import com.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@RestController
@RequestMapping("/music")
@CrossOrigin
public class MusicController {
    @Autowired
    private IMusicService service;



    @GetMapping("/getAll")
    public List<Music> getAll(){
        return service.list();
    }

}
