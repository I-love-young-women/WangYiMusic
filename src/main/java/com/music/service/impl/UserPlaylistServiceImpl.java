package com.music.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Music;
import com.music.pojo.UserPlaylist;
import com.music.mapper.UserPlaylistMapper;
import com.music.service.IUserPlaylistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@Service
public class UserPlaylistServiceImpl extends ServiceImpl<UserPlaylistMapper, UserPlaylist> implements IUserPlaylistService {

//    @Override
//    public List<Music> getMusicListByPId(int id) {
//        return Db.lambdaQuery(Music.class)
//                .eq(get);
//    }
}
