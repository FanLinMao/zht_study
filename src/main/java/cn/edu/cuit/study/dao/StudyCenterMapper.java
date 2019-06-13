package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.Course;
import cn.edu.cuit.study.utils.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @date: 2019/5/31
 * @author: Flemming
 * @description: 学习中心数据库连接
 */
@Repository
public interface StudyCenterMapper {

    /**
     * 根据用户ID，查看用户的选课信息
     * @param userId
     * @return 选课信息
     *
     */
    public List<Map> getSelectCourseByUserId(int userId);

    /**
     * 根据课程ID，查看该课程信息
     * @param courseId
     * @return
     *
     */
    public Course getCourseInfoByCourseId(int courseId);

    /**
     * 获取到课程ID和用户ID，执行选课操作
     * @param courseId
     * @param userId
     * @return
     *
     */
    public int addCourse(int courseId, int userId);

    /**
     * 获取到课程ID和用户ID，执行退课操作
     * @param courseId
     * @param userId
     * @return
     *
     */
    public int removeCourse(int courseId, int userId);

    /**
     * 修改选课的人数
     * @param courseId
     * @return
     */
    public int updateSelectCourseNumByCourseId(int courseId);

    /**
     * 根据课程ID获取选课的人数
     * @param courseId
     * @return
     */
    public int getSelectCourseNumByCourseId(int courseId);

    /**
     * 根据用户ID和课程ID，添加用户选择课程的评论
     * @param courseId
     * @param userId
     * @param content
     * @param date
     * @return
     */
    public int addCourseCommentByCourseIdAndUserId(@Param("courseId")int courseId, @Param("userId")int userId, @Param("content")String content, @Param("date")String date);

    /**
     * 根据用户ID和课程ID，添加用户选择课程的笔记
     * @param courseId
     * @param userId
     * @param note
     * @param date
     * @return
     */
    public int addCourseNoteByCourseIdAndUserId(@Param("courseId") int courseId, @Param("userId")int userId, @Param("note")String note, @Param("date")String date);

    /**
     * 根据课程ID分页查询该课程的评论信息
     * @param startNum 开始页
     * @param pageSize 查询多少条
     * @return
     */
    public List<Map> getReviewsByCourseId(@Param("courseId") int courseId, @Param("startNum") int startNum, @Param("pageSize") int pageSize);

    /**
     * 根据课程ID查询评论信息的总页数
     * @param courseId
     * @return
     */
    public int getReviewTotalPage(int courseId);

}
