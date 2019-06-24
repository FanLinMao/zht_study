package cn.edu.cuit.study.service;

import cn.edu.cuit.study.entity.User;

import java.util.List;

/**
 * author: zjj
 * 用户信息管理服务接口
 */
public interface UserInfoService {
    /**
     * 获取用户信息，执行添加操作
     * @return
     */
    public boolean addUser(User user);

    /**
     * 获取用户ID，执行删除操作
     * @param userID
     * @return
     */
    public boolean deleteUser(int userID);

    /**
     * 获取修改后的信息，执行更新操作
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> selectUser();

    /**
     *获取用户ID，执行查询操作
     * @param userID
     * @return
     */
    public User findUser(int userID);
}
