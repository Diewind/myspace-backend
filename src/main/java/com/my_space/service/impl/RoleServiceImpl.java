package com.my_space.service.impl;

import com.my_space.entity.Role;
import com.my_space.mapper.RoleMapper;
import com.my_space.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author harry
 * @since 2023-7-22 15:50:39
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
