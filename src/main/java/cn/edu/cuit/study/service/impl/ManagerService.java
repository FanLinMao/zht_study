package cn.edu.cuit.study.service.impl;

import cn.edu.cuit.study.dao.ManagerMapper;
import cn.edu.cuit.study.dao.UserMapper;
import cn.edu.cuit.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jayl1n
 * @date 2019/6/4 15:28
 */
@Service
public class ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    UserMapper userMapper;


    /**
     * 获取管理员信息
     */
    public User getManagerProfile(String userId) {
        User managerProfile;
        try {
            int userid = Integer.parseInt(userId);
            managerProfile = userMapper.selectByPrimaryKey(userid);
        } catch (Exception e) {
            managerProfile = userMapper.selectByPrimaryKey(20001);
        }
        return managerProfile;
    }


    /**
     * 更新信息
     *
     * @param user
     * @return
     */
    public boolean updateManagerProfile(User user) {
        return managerMapper.updateManagerProfile(user);
    }
}
