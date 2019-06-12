package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author Jayl1n
 * @date 2019/6/4 15:30
 */
@Repository
public interface ManagerMapper {

    /**
     * 获取管理员个人信息
     * @param userId
     */
    public User getManagerProfile(Integer userId);


    boolean updateManagerProfile(User user);
}
