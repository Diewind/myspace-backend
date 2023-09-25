package com.my_space.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my_space.common.utils.MessageSourceUtil;
import com.my_space.common.utils.Result;
import com.my_space.common.validator.group.AddGroup;
import com.my_space.entity.Role;
import com.my_space.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author lyh
 * @since 2020-06-08
 */
@RestController
@RequestMapping("/back/role")
@Api(tags = "角色信息")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MessageSourceUtil messageSourceUtil;
    @Resource
    private ValueOperations valueOperations;

    @ApiOperation(value = "获取所有角色信息")
    @GetMapping("/getListOfRole")
    public Result getListOfRole(Long current, Long size) {
        Page<Role> page = new Page(current, size);
        return Result.ok().data("page", roleService.page(page, null));
    }

    @ApiOperation(value = "删除指定角色的用户")
    @DeleteMapping("/deleteRole")
    public Result deleteRole(@RequestParam String name) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", name);
        if(roleService.removeByMap(hashMap)){
            return Result.ok().message("数据删除成功");
        }else{
            return Result.error().message("数据删除失败");
        }
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("/saveRole")
    public Result saveRole(@Validated({AddGroup.class}) @RequestBody Role role) {
        if(roleService.saveOrUpdate(role)) {
            return Result.ok().message("数据添加成功");
        }else{
            return Result.error().message("数据添加失败");
        }
    }

    @ApiOperation(value = "修改角色")
    @PostMapping("/updateRole")
    public Result updateRole(@Validated({AddGroup.class}) @RequestBody Role role) {
        if(roleService.updateById(role)) {
            return Result.ok().message("数据修改成功");
        }else{
            return Result.error().message("数据修改失败");
        }
    }
}

