package com.music.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.*;
import com.music.service.IPlaylistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@RestController
@CrossOrigin
@RequestMapping("/playlists")
public class PlaylistsController {

    @Autowired
    private IPlaylistsService service;
    @PostMapping("/addList")
    public Result addList(@RequestBody Playlists playlists){
        boolean save = Db.save(playlists);
        if (save){
            return new Result(200, true,"successful!");
        }
        return new Result(205, false,"failed!");
    }

    @GetMapping("/getList")
    public Result getList(Integer id) {
        List<Playlists> list = Db.lambdaQuery(Playlists.class)
                .eq(Playlists::getUserId, id)
                .list().stream()
                .map(m -> m.setUsers(Db.getById(m.getUserId(), Users.class)))
                .collect(Collectors.toList());
        for (Playlists playlists : list) {
            playlists.setList(new ArrayList<>());
            List<UserPlaylist> list1 = Db.lambdaQuery(UserPlaylist.class)
                    .eq(UserPlaylist::getPlaylistId, playlists.getPlaylistId())
                    .select(UserPlaylist::getMusicId)
                    .list();
          list1.forEach(a->{
              Music one = Db.lambdaQuery(Music.class).eq(Music::getMusicId, a.getMusicId()).one();
              List<Music> list2 = playlists.getList();
              list2.add(one);
              playlists.setList(list2);
          });
        }
        return new Result(200, list, "ok");
    }


    @PostMapping("/upMusic")
    public Result upMusic(@RequestBody Music music){
        boolean b = Db.updateById(music);
        if (b){
            return new Result(200, true,"successful!");
        }
        return new Result(205, false,"failed!");
    }

}
