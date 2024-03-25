package com.music.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("music")
@NoArgsConstructor
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;

    public Music(Integer musicId, String title, String artist, String album, String fileUrl, String lyrics, LocalDateTime createdAt) {
        this.musicId = musicId;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.fileUrl = fileUrl;
        this.lyrics = lyrics;
        this.createdAt = createdAt;
    }

    public Music(String title, String artist, String album, String fileUrl, String lyrics) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.fileUrl = fileUrl;
        this.lyrics = lyrics;
    }

    @TableId(value = "music_id", type = IdType.AUTO)
    private Integer musicId;

    @TableField("title")
    private String title;

    @TableField("artist")
    private String artist;

    @TableField("album")
    private String album;

    @TableField("file_url")
    private String fileUrl;

    @TableField("lyrics")
    private String lyrics;

    @TableField("created_at")
    private LocalDateTime createdAt;


}
