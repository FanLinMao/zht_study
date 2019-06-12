package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer userid);

    User selectManagerByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}