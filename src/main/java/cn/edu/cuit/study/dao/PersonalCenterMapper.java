package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.Course;
import cn.edu.cuit.study.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description 个人中心数据操作接口
 * @author hl
 */
@Repository
public interface PersonalCenterMapper {

    /**
     * 获取该用户的基本信息
     * @param userId 用户编号
     * @return 用户基本信息
     */
    User getUser(int userId);

    /**
     * 更新该用户的基本信息
     * @param user 该用户的基本信息
     * @return 返回更新结果
     */
    int updateByUser(User user);

    /**
     * 获取所有课程信息
     * @param userId 该用户的基本信息
     * @return 课程信息集合
     */
    List<Course> getAllCourse(int userId);

    /**
     * 根据课程ID获取课程信息
     * @param courseId 课程ID
     * @return 课程信息
     */
    Course findByIdCourse(int courseId);

    /**
     * 根据课程编号查询该课程的选课信息
     * @param userId 用户编号
     * @return 选课信息
     */
    List<Map> getSelectInformation(int userId);

}
