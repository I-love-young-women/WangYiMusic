package com.music.service;

import com.music.pojo.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
public interface IUsersService extends IService<Users> {
    boolean regUser(Users users);
    String login(String phone,String pwd);
}
