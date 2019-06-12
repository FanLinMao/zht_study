package cn.edu.cuit.study.service.impl;

import cn.edu.cuit.study.dao.LoginMapper;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * @date: 2019/6/4
 * @author: zjj
 * @description: 登录注册业务层
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginMapper LoginMappe;

    @Override
    public User Login2(String phone) {
        return LoginMappe.Login2(phone);
    }

    public boolean Register(User user){
        int result =  LoginMappe.Register(user);
        return result > 0;
    }
}
