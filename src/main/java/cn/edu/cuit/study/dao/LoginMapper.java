package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @date: 2019/6/4
 * @author: zjj
 * @description: 登录注册数据库连接
 */
@Repository
public interface LoginMapper {
    /**
     * 输入手机号，获取用户全部信息
     * @return
     */
    public User Login2(@Param("phone") String phone);

    /**
     *获取用户信息，执行添加操作
     * @return
     */
    public int Register(User user);
}
