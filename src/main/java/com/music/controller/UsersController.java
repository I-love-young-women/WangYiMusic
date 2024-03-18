package com.music.controller;


import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.music.pojo.Result;
import com.music.pojo.Users;
import com.music.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author music
 * @since 2024-02-25
 */
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

    @Resource
    private IUsersService service;
    @Autowired
    private HttpServletRequest request;

    @PostMapping("/regUser")
    public Result regUser(@RequestBody Users users){
        boolean b = service.regUser(users);
        if (b){
            return new Result(200, true,"reg successful！");
        }
        return new Result(205, false,"reg failed！");
    }

    @GetMapping("/login/{phoneNumber}/{password}")
    public Result login(@PathVariable String phoneNumber,@PathVariable String password){
        String token = service.login(phoneNumber, password);
        System.out.println(token);
        return new Result(200,token,"login successful !");
    }

    @GetMapping("/function/getOne")
    public Result getOne(){
        Object userId = request.getAttribute("userId");
        int id = Integer.parseInt(userId.toString());

        System.out.println(id);
        Users user = Db.getById(id, Users.class);
        return new Result(200,user,"ok!");
    }

}
