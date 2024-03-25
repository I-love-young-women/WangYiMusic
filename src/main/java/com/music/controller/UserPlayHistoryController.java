package com.music.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.mapper.MusicMapper;
import com.music.mapper.UserPlayHistoryMapper;
import com.music.pojo.Music;
import com.music.pojo.Result;
import com.music.pojo.UserPlayHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/history")
@CrossOrigin
public class UserPlayHistoryController {

    @Autowired
    private UserPlayHistoryMapper userPlayHistoryMapper; // 假设已经定义了对应的 Mapper

    @Autowired
    private MusicMapper musicMapper; // 假设已经定义了对应的 Mapper

    @PostMapping("/addHis")
    public Result addHis(@RequestBody UserPlayHistory userPlayHistory) {
        return new Result(200, Db.saveOrUpdate(userPlayHistory), "修改成功");
    }

    @GetMapping("/getHis")
    public List<Music> getMusic(Integer id) {
        List<UserPlayHistory> list = Db.lambdaQuery(UserPlayHistory.class)
                .eq(UserPlayHistory::getUserId, id)
                .list();
        List<Integer> musicIds = list.stream().map(UserPlayHistory::getMusicId).collect(Collectors.toList());
        QueryWrapper<Music> musicQueryWrapper = new QueryWrapper<>();
        musicQueryWrapper.in("music_id", musicIds);
        return musicMapper.selectList(musicQueryWrapper);
    }

    @DeleteMapping("/delete/{uId}/{mId}")
    public Result delete(@PathVariable("uId") Integer uId,@PathVariable("mId") Integer Mid){
        return new Result(200,Db.lambdaUpdate(UserPlayHistory.class)
                .eq(UserPlayHistory::getMusicId,Mid)
                .eq(UserPlayHistory::getUserId,uId)
                .remove(),"删除成功");
    }
}
