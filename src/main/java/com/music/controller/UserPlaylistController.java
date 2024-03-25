package com.music.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Music;
import com.music.pojo.Playlists;
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
@RequestMapping("/user-playlist")
@CrossOrigin
public class UserPlaylistController {

    @PostMapping("/addList")
    public Result addList(@RequestBody UserPlaylist playlist){
        boolean save = Db.save(playlist);
        if (save){
            return new Result(200,save,"successful!");
        }
        return new Result(205,save,"failed!");
    }

    @DeleteMapping("/dMusic/{pId}/{mId}")
    public Result rmList(@PathVariable("pId") Integer pId,@PathVariable("mId") Integer mId){
        System.err.println(pId);
        System.err.println(mId);

        boolean remove = Db.lambdaUpdate(UserPlaylist.class)
                .eq(UserPlaylist::getMusicId, mId)
                .eq(UserPlaylist::getPlaylistId, pId)
                .remove();
        return new Result(200,"remove","删除成功");
    }



}
