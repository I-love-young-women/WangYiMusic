package com.music.controller;


import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Result;
import com.music.pojo.UserPlaylist;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user-playlist")
public class UserPlaylistController {

    @PostMapping("/addList")
    public Result addList(@RequestBody UserPlaylist playlist){
        boolean save = Db.save(playlist);
        if (save){
            return new Result(200, true,"successful!");
        }
        return new Result(205, false,"failed!");
    }
}
