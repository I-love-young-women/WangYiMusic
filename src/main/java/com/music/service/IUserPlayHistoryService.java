package com.music.service;

import com.music.pojo.Music;
import com.music.pojo.Result;
import com.music.pojo.UserPlayHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
public interface IUserPlayHistoryService extends IService<UserPlayHistory> {
    Result addOrUpdate(UserPlayHistory history);


}
