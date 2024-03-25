package com.music.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@TableName("playlists")
@AllArgsConstructor
@NoArgsConstructor
public class Playlists implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "playlist_id", type = IdType.AUTO)
    private Integer playlistId;

    @TableField("user_id")
    private Integer userId;

    @TableField("title")
    private String title;

    @TableField("is_public")
    private Boolean isPublic;

    @TableField("cover_image")
    private String coverImage;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField(exist = false)
    private Users users;

//    @TableField(exist = false)
//    private UserPlaylist userPlaylist;
//
    @TableField(exist = false)
    private List<UserPlaylist> userPlaylists;


    @TableField(exist = false)
    private List<Music> list;

    public Playlists(Integer playlistId, String title, Boolean isPublic, String coverImage, LocalDateTime createdAt, Users users, List<Music> list) {
        this.playlistId = playlistId;
        this.title = title;
        this.isPublic = isPublic;
        this.coverImage = coverImage;
        this.createdAt = createdAt;
        this.users = users;
        this.list = new ArrayList<Music>();
    }
}
