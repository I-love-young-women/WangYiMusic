package com.music.controller;


import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Result;
import com.music.pojo.Users;
import com.music.service.IUsersService;
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
@RequestMapping("/users")
public class UsersController {

    @Resource
    private IUsersService service;
    @PostMapping("/regUser")
    public Result regUser(@RequestBody Users users){
        boolean b = service.regUser(users);
        if (b){
            return new Result(200,b,"reg successful！");
        }
        return new Result(205,b,"reg failed！");
    }

    @GetMapping("/login/{phoneNumber}/{password}")
    public Result login(@PathVariable String phoneNumber,@PathVariable String password){
        String login = service.login(phoneNumber, password);
        System.out.println(login);
        return new Result(200,login,"login successful !");
    }

}
