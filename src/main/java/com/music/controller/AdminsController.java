package com.music.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Admins;
import com.music.pojo.Result;
import com.music.service.impl.AdminsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@RestController
@RequestMapping("/admins")
public class AdminsController {

    @Resource
    private AdminsServiceImpl service;


    @PostMapping("/addAdmin")
    public Result addAdmin(@RequestBody  Admins admins){
        if (service.save(admins)) {
            return new Result(200,true,"add successful ! ");
        }
        return new Result(205,false,"add failed ! ");
    }

    @PostMapping("/login")
    public Result login(Integer id,String pwd){
        Admins admins = service.getById(id);
        QueryWrapper<Admins> wrapper = new QueryWrapper<Admins>().eq("admin_id",id)
                .eq("password",pwd);
        Admins one = service.getOne(wrapper);
        if (one!=null){
            return new Result(200,one,"login successful ! ");
        }
        return new Result(205,null,"login failed ! ");
    }
}
