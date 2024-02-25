package com.music.service.impl;

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

}
