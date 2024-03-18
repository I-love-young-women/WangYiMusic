package com.music.controller;


import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mpatric.mp3agic.*;
import com.music.pojo.Music;
import com.music.pojo.Result;
import com.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author music
 * @since 2024-02-25
 *
 *
 * 
 */
@RestController
@RequestMapping("/music")
@CrossOrigin
public class MusicController {
    @Autowired
    private IMusicService service;

    @GetMapping("/getAll/{pageNum}/{size}")
    public Result getAll(@PathVariable Integer pageNum, @PathVariable Integer size) {
        PageHelper.startPage(pageNum, size);
        List<Music> list = service.list();
        PageInfo<Music> pageInfo = new PageInfo<>(list, 3);
        return new Result(200, pageInfo, "获取歌单成功");
    }

    @GetMapping("/getCover/{id}")
    public Result getCover(@PathVariable Integer id) throws InvalidDataException, IOException, UnsupportedTagException {
        Music music = Db.getById(id, Music.class);
        return service.getCover(music);
    }

    @GetMapping("/getAll")
    public Result getAll() {
        return new Result(200, service.list(), "获取歌单成功");
    }
}








