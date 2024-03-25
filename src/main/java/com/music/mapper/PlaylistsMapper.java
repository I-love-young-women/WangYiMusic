package com.music.mapper;

import com.music.pojo.Playlists;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>id
 *
 * @author music
 * @since 2024-02-25
 */
@Mapper
public interface PlaylistsMapper extends BaseMapper<Playlists> {
        Playlists getPlayList(@Param("id")int id );
}
