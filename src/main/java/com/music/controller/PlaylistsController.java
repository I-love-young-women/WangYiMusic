package com.music.controller;


import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Playlists;
import com.music.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@RestController
@CrossOrigin
    @RequestMapping("/playlists")
public class PlaylistsController {

    @PostMapping("/upList")
    public Result upList(@RequestBody Playlists playlists){

        boolean save = Db.saveOrUpdate(playlists);
        if (save){
            return new Result(200, true,"successful!");
        }
        return new Result(205, false,"failed!");
    }
    
}
