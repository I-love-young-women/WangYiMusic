package com.music.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.Db;
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

import java.io.*;
import java.util.Arrays;

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
            mp3file = new Mp3File("src/main/resources/static/"+music.getFileUrl());
        } catch (IOException | UnsupportedTagException | InvalidDataException e) {
            e.printStackTrace();
        }
        byte[] albumImageData ;
        ID3v2 id3v2Tag = mp3file.getId3v2Tag();
        albumImageData = id3v2Tag.getAlbumImage();
        System.out.println(Arrays.toString(albumImageData)+"222");
        if (albumImageData != null) {
            System.out.println("Have album image data, length: " + albumImageData.length + " bytes");
            System.out.println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
            return new Result(200, albumImageData, "ok");
        }
        return new Result(220,"null","无封面");

    }

//    @Override
//    public boolean addMusic(InputStream is) {
//        String rootPath="E:/KG28/kg28mvn/hospital/target/classes/static/";
//        String path="music/"+"_"+System.currentTimeMillis()+".mp3";
//        DataInputStream dis=new DataInputStream(is);
//        try {
//            DataOutputStream dos=
//                    new DataOutputStream(new FileOutputStream(rootPath+path));
//            byte[] bytes=new byte[1024*10*10];
//            int len=0;
//            while ((len=dis.read(bytes))!=-1){
//                dos.write(bytes,0,len);
//            }
//            dis.close();
//            dos.close();
//            return Db.update(Music.class);
//
//        }catch (IOException e){
//            e.printStackTrace();
//            return false;
//        }
//    }
}
