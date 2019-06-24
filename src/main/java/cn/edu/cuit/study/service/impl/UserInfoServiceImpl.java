package cn.edu.cuit.study.service.impl;

import cn.edu.cuit.study.dao.UserinfoMapper;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * author:zjj
 * 用户管理 业务层
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;
    /**
     * 获取用户信息，执行添加操作
     * @return
     */
    public boolean addUser(User user){
        System.out.println("adduser用户ID为：" + user.getUserID());
        int result = userinfoMapper.addUser(user);
        return result > 0;
    }

    /**
     * 获取用户ID，执行删除操作
     * @param userID
     * @return
     */
    public boolean deleteUser(int userID){
        System.out.println("deleteuser用户ID为：" + userID);
        int result = userinfoMapper.deleteUser(userID);
        return result > 0;
    }

    /**
     * 获取修改后的信息，执行更新操作
     * @return
     */
    public boolean updateUser(User user){
        System.out.println("updateuser用户ID为：" + user.getUserID());
        int result = userinfoMapper.updateUser(user);
        return result > 0;
    }

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> selectUser(){ return userinfoMapper.selectUser(); }

    /**
     *获取用户ID，执行查询操作
     * @param userID
     * @return
     */
    public User findUser(int userID){
        System.out.println("finduser用户ID为：" + userID);
        return userinfoMapper.findUser(userID); }
}
