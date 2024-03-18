package com.music.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

}
