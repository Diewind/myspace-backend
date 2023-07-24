package com.my_space.controller;

import com.my_space.common.validator.group.AddGroup;
import com.my_space.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import com.my_space.common.utils.MessageSourceUtil;
import com.my_space.common.utils.Result;
import com.my_space.service.UserService;

import java.util.HashMap;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lyh
 * @since 2020-06-08
 */
@RestController
@RequestMapping("/back/user")
@Api(tags = "用户信息")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSourceUtil messageSourceUtil;
    @Resource
    private ValueOperations valueOperations;

    @ApiOperation(value = "获取所有用户信息")
    @GetMapping("/getListOfUser")
    public Result getListOfUser() {
        return Result.ok().data("user", userService.list());
    }

    @ApiOperation(value = "删除指定姓名的用户")
    @DeleteMapping("/deleteUser")
    public Result deleteUser(@RequestParam String name) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", name);
        if(userService.removeByMap(hashMap)){
            return Result.ok().message("数据删除成功");
        }else{
            return Result.error().message("数据删除失败");
        }
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("/saveUser")
    public Result saveUser(@Validated({AddGroup.class}) @RequestBody User user) {
        if(userService.save(user)) {
            return Result.ok().message("数据添加成功");
        }
        return Result.error().message("数据添加失败");
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("/updateUser")
    public Result updateUser(@Validated({AddGroup.class}) @RequestBody User user) {
        if(userService.save(user)) {
            return Result.ok().message("数据修改成功");
        }
        return Result.error().message("数据修改成功");
    }
}

