package com.situ.chronicmange.service;

import com.situ.chronicmange.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
public interface IUserService extends IService<User> {

    User dealLogin(User user) throws Exception;
    void modifiedPwdUser(User user,String newPassword,String rePassword) throws Exception;
    void add(User user, String respassword) throws Exception;
}