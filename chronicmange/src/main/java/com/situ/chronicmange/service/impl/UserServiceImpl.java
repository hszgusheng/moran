package com.situ.chronicmange.service.impl;

import com.situ.chronicmange.entity.User;
import com.situ.chronicmange.mapper.UserMapper;
import com.situ.chronicmange.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.chronicmange.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *用户表  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User dealLogin(User user) throws Exception {
        //参数校验
        //账户是否存在
        //验证密码是否正确
        //验证账户状态
        String userName=user.getUsername();
        String passWord=user.getPassword();
if(userName==null||"".equals(userName)){
    throw new Exception("温馨提示:用户名为空");
}
        if(passWord==null||"".equals(passWord)){
            throw new Exception("温馨提示:密码为空");
        }
        if(userName.length()<3||userName.length()>16){
            throw new Exception("温馨提示:用户名必须3-16个字符");
        }
        if(passWord.length()<3||passWord.length()>16){
            throw new Exception("温馨提示:密码必须3-16个字符");
        }
        //根据登录用户名查询user表
        User sUser=userMapper.selectUserByUserName(userName);
        if(sUser==null){
            throw new Exception("温馨提示:账户不存在");

        }
        if(!sUser.getPassword().equals(MD5Util.getMD5(passWord))){
            throw new Exception("温馨提示:密码错误");

        }
        if(sUser.getStatus()==1){
            throw new Exception("温馨提示:账户已被禁用");
        }
        return sUser;
    }
    @Override
    public void modifiedPwdUser(User user,String newPassword,String rePassword) throws Exception{
        User oldUser=userMapper.selectById(user.getId());
        if(!oldUser.getPassword().equals(MD5Util.getMD5(user.getPassword()))){
            throw new Exception("旧密码错误");
        }
        if(newPassword==null||"".equals(newPassword)){
            throw new Exception("新密码为空");
        }
        if(rePassword==null||"".equals(rePassword)){
            throw new Exception("确认密码为空");
        }
        if(!newPassword.equals(rePassword)){
            throw  new  Exception("两次输入密码不一致");
        }
        oldUser.setPassword(MD5Util.getMD5(newPassword));
        userMapper.updateById(oldUser);
    }
    public void add(User user, String respassword) throws Exception{
        if(user.getUsername()==null||"".equals(user.getUsername())){
            throw new Exception("用户名为空");
        }
        if(user.getPassword()==null||"".equals(user.getPassword())){
            throw new Exception("密码为空");
        }
        if(user.getUsername()==null||"".equals(user.getUsername()))
        {
            throw new Exception("姓名为空");
        }
        if(respassword==null||"".equals(respassword)){
            throw new Exception("确认密码为空");
        }
        if(!user.getPassword().equals(respassword)){
            throw  new  Exception("两次输入密码不一致");
        }
        User sUser=userMapper.selectUserByUserName(user.getUsername());
        if(sUser!=null){
            throw new Exception("温馨提示:账户已存在");

        }
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        userMapper.insert(user);
    }
}
