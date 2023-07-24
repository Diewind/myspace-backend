package com.my_space.service.impl;

import com.my_space.entity.User;
import com.my_space.mapper.UserMapper;
import com.my_space.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author harry
 * @since 2023-7-22 15:50:39
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
