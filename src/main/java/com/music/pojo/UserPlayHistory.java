package com.music.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
@TableName("user_play_history")
public class UserPlayHistory implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableField("user_id")
    private Integer userId;

    @TableId( value = "music_id", type = IdType.AUTO)
    private Integer musicId;

    @TableField("play_time")
    private LocalDateTime playTime;

    @TableField(exist = false)
    private List<Music> musics;


}
