package com.music.service;

import com.music.pojo.Playlists;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
public interface IPlaylistsService extends IService<Playlists> {
    Playlists getPlayList(int id );

}
