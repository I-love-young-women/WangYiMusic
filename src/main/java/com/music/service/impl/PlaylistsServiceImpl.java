package com.music.service.impl;

import com.music.pojo.Playlists;
import com.music.mapper.PlaylistsMapper;
import com.music.service.IPlaylistsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@Service
public class PlaylistsServiceImpl extends ServiceImpl<PlaylistsMapper, Playlists> implements IPlaylistsService {

}
