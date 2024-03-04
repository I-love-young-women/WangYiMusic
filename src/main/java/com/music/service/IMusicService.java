package com.music.service;

import com.mpatric.mp3agic.ID3v2;
import com.music.pojo.Music;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.pojo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
public interface IMusicService extends IService<Music> {
    Result getCover(Music music);

}
