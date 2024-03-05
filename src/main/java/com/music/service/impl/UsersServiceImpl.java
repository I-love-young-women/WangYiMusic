package com.music.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Users;
import com.music.mapper.UsersMapper;
import com.music.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.util.MD5Util;

import com.music.util.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

//    @Resource
//    private RedisUtil redisUtil;

    @Override
    public boolean regUser(Users users) {
        Users byId = Db.getById(users.getUserId(), Users.class);
        if (byId!=null){
            return false;
        }
        users.setNickname(System.currentTimeMillis()+"");
        String md5 = MD5Util.stringToMD5(users.getPassword());
        users.setPassword(md5);
        return Db.save(users);
    }

    @Override
    public String login(String phoneNumber, String password) {
//        System.out.println(phoneNumber+"shouji");
//        System.out.println(password+"1");
//        System.out.println(MD5Util.stringToMD5(password));
        Users one = Db.lambdaQuery(Users.class)
                .eq(Users::getPhoneNumber, phoneNumber)
                .eq(Users::getPassword, MD5Util.stringToMD5(password)).one();
//        System.out.println(one+"2");
        if (one!=null){
//            UUID token = UUID.randomUUID();
            HashMap<String, Object> map = new HashMap<>();
            map.put("user",one);
            //            redisUtil.set(token.toString(),one);
            return TokenUtil.makeToken(map);
        }
        return null;
    }
}
