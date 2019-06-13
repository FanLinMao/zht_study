package cn.edu.cuit.study.service;

import cn.edu.cuit.study.entity.Course;
import cn.edu.cuit.study.utils.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @date: 2019/5/31
 * @author: Flemming
 * @description: 学习模块服务接口
 */
public interface StudyCenterService {

    /**
     * 根据用户ID，查看用户的选课信息
     * @param userId
     * @return 选课信息
     * @throws Exception
     */
    public List<Map> getSelectCourseByUserId(int userId) throws Exception;

    /**
     * 根据课程ID，查看该课程信息
     * @param courseId
     * @return
     * @throws Exception
     */
    public Course getCourseInfoByCourseId(int courseId) throws Exception;

    /**
     * 获取到课程ID和用户ID，执行选课操作
     * @param courseId
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean addCourse(int courseId, int userId) throws Exception;

    /**
     * 获取到课程ID和用户ID，执行退课操作
     * @param courseId
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean removeCourse(int courseId, int userId) throws Exception;

    /**
     * 添加 用户选择的课程笔记
     * @param courseId
     * @param userId
     * @param note
     * @return
     * @throws Exception
     */
    public boolean addCourseNote(int courseId, int userId, String note) throws Exception;

    /**
     * 插入 当前用户对选择课程的评论
     * @param courseId
     * @param userId
     * @param content
     * @return
     * @throws Exception
     */
    public boolean addCourseComment(int courseId, int userId, String content) throws Exception;

    /**
     * 根据课程ID，获取选课当前课程的人数
     * @param courseId
     * @return
     * @throws Exception
     */
    public int getSelectCourseCounts(int courseId) throws Exception;

    /**
     * 根据课程ID查询 该课程的所有评论信息
     * @param courseId
     * @return
     * @throws Exception
     */
    public PageBean<Map> getReviewsByPage(int courseId, int pageNo, int pageSize) throws Exception;




}
