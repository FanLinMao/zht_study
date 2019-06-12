package cn.edu.cuit.study.service;

import cn.edu.cuit.study.entity.User;


/**
 * @date: 2019/6/4
 * @author: zjj
 * @description: 登录注册服务接口
 */
public interface LoginService {

    /**
     * 输入手机号，获取用户全部信息
     * @param phone
     * @return
     */
    public User Login2(String phone);


    /**
     * 获取用户信息，执行添加操作
     *
     * @return
     */
    public boolean Register(User user);
}

