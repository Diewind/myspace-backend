package com.my_space.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my_space.modules.sys.entity.SysUser;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author lyh
 * @since 2020-07-02
 */
public interface SysUserService extends IService<SysUser> {
    public boolean saveUser(SysUser sysUser);
}
