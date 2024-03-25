package com.music.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Result;
import com.music.pojo.UserPlayHistory;
import com.music.mapper.UserPlayHistoryMapper;
import com.music.service.IUserPlayHistoryService;
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
public class UserPlayHistoryServiceImpl extends ServiceImpl<UserPlayHistoryMapper, UserPlayHistory> implements IUserPlayHistoryService {

    @Override
    public Result addOrUpdate(UserPlayHistory history) {
        return new Result(200,Db.saveOrUpdate(history),"ok") ;
    }
}
