package com.music.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mpatric.mp3agic.*;
import com.music.pojo.Music;
import com.music.pojo.Result;
import com.music.service.IMusicService;
import jdk.internal.instrumentation.Logger;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@RestController
@RequestMapping("/music")
@CrossOrigin
public class MusicController {
    @Autowired
    private IMusicService service;

    @GetMapping("/getAll/{pageNum}/{size}")
    public Result getAll(@PathVariable Integer pageNum, @PathVariable Integer size) {
        PageHelper.startPage(pageNum, size);
        List<Music> list = service.list();
        PageInfo<Music> pageInfo = new PageInfo<>(list, 3);
        return new Result(200, pageInfo, "获取歌单成功");
    }

    @GetMapping("/getCover/{id}")
    public Result getCover(@PathVariable Integer id) throws
            InvalidDataException, IOException, UnsupportedTagException {
        Music music = Db.getById(id, Music.class);
        return service.getCover(music);
    }

    @PostMapping("/addMusic")
    public Result addMusic(MultipartFile file,String lyrics,String album,String artist,String title) throws IOException {
        String fileName = file.getOriginalFilename();
        String rootPath = "D:/Idea/KG28Web/WangYiMusic/target/classes/static/";
        String rootPath1 = "D:/Idea/KG28Web/WangYiMusic/src/main/resources/static/";
        String path = "music/" + fileName;
//        System.out.println(path);
        InputStream is = file.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos =
                new DataOutputStream(new FileOutputStream(rootPath + path));
        byte[] bytes = new byte[1024 * 100 * 10];
        int len = 0;
        while ((len = dis.read(bytes)) != -1) {
            dos.write(bytes, 0, len);
        }

        InputStream is1 = file.getInputStream();
        DataInputStream dis1 = new DataInputStream(is1);
        DataOutputStream dos1 =
                new DataOutputStream(new FileOutputStream(rootPath1 + path));
        byte[] bytes1 = new byte[1024 * 100 * 10];
        int len1 = 0;
        while ((len1 = dis1.read(bytes1)) != -1) {
            dos1.write(bytes1, 0, len1);
        }
//        System.out.println(dos);
        dis.close();
        dos.close();
        dis1.close();
        dos1.close();
//        System.out.println(path);
        Music music = new Music(title,artist,album,path,lyrics);
        boolean save = Db.save(music);

        if (save){
            System.out.println(save);
            return new Result(200, true, "ok!");
        }else {
            return new Result(205, false, "error!");
        }
    }
    @GetMapping("/getAll")
    public Result getAll() {
        return new Result(200, service.list(), "获取歌单成功");
    }

    @GetMapping("/getMusic")
    public Result getMusic(String name){
        return service.getMusic(name);
    }

    @PostMapping("/upMusic")
    public Result upMusic(@RequestBody Music music){
        boolean b = Db.updateById(music);
        if (b){
            return new Result(200, true,"successful!");
        }
        return new Result(205, false,"failed!");
    }

    @GetMapping("/downloadFile")
    public void downloadFiles(@RequestParam("file") String downUrl, HttpServletRequest request, HttpServletResponse response) {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        String rootPath = "D:/Idea/KG28Web/WangYiMusic/target/classes/static/";
        BufferedInputStream bufferedInputStream = null;
        byte[] bytes = new byte[1024];
        File file = new File(rootPath+downUrl);
        String fileName = file.getName();
//        logger.info("本次下载的文件为" + downUrl);
        // 获取输出流
        try {
//             StandardCharsets.ISO_8859_1 *=UTF-8'
//             response.setHeader("Content-Disposition", "attachment;filename=" +  new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            // 以流的形式返回文件
            inputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(inputStream);
            outputStream = response.getOutputStream();
            int i = bufferedInputStream.read(bytes);
            while (i != -1) {
                outputStream.write(bytes, 0, i);
                i = bufferedInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    }










