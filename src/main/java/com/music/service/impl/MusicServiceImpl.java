package com.music.service.impl;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.music.pojo.Music;
import com.music.mapper.MusicMapper;
import com.music.pojo.Result;
import com.music.service.IMusicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements IMusicService {

    @Override
    public Result getCover(Music music) {
        Mp3File mp3file = null;
        try {
            mp3file = new Mp3File("src/main/resources/static/"+music.getUrl());
        } catch (IOException | UnsupportedTagException | InvalidDataException e) {
            e.printStackTrace();
        }
        byte[] albumImageData ;
        ID3v2 id3v2Tag = mp3file.getId3v2Tag();
        albumImageData = id3v2Tag.getAlbumImage();
        if (albumImageData != null) {
            System.out.println("Have album image data, length: " + albumImageData.length + " bytes");
            System.out.println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
            return new Result(200, albumImageData, "ok");
        }
        return new Result(220,"null","无封面");

    }
}
