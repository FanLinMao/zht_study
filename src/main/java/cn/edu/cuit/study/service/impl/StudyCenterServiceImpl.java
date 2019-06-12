package cn.edu.cuit.study.service.impl;

import cn.edu.cuit.study.constant.DateFormat;
import cn.edu.cuit.study.dao.StudyCenterMapper;
import cn.edu.cuit.study.entity.Course;
import cn.edu.cuit.study.service.StudyCenterService;
import cn.edu.cuit.study.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @date: 2019/5/31
 * @author: Flemming
 * @description: 学习中心业务层
 */
@Service
public class StudyCenterServiceImpl implements StudyCenterService {

    @Autowired
    private StudyCenterMapper studyCenterMapper;


    public List<Map> getSelectCourseByUserId(int userId) throws Exception {
        return studyCenterMapper.getSelectCourseByUserId(userId);
    }

    @Override
    public Course getCourseInfoByCourseId(int courseId) throws Exception {
        return studyCenterMapper.getCourseInfoByCourseId(courseId);
    }

    @Override
    public boolean addCourse(int courseId, int userId) throws Exception {
        //添加课程
        int result = studyCenterMapper.addCourse(courseId, userId);
        //修改选课人数
        int num = studyCenterMapper.updateSelectCourseNumByCourseId(courseId);

        return (result>0) && (num>0);
    }

    @Override
    public boolean removeCourse(int courseId, int userId) throws Exception {
        int result = studyCenterMapper.removeCourse(courseId, userId);
        return result > 0;
    }

    @Override
    public boolean addCourseNote(int courseId, int userId, String note) throws Exception {
        //默认插入格式化后的当前时间
        String date = DateUtils.formatDate(new Date(), DateFormat.DATE_FORMAT);
        int result = studyCenterMapper.addCourseNoteByCourseIdAndUserId(courseId, userId, note, date);
        return result > 0;
    }

    @Override
    public boolean addCourseComment(int courseId, int userId, String content) throws Exception {
        //默认插入格式化后的当前时间
        String date = DateUtils.formatDate(new Date(), DateFormat.DATE_FORMAT);
        int res = studyCenterMapper.addCourseCommentByCourseIdAndUserId(courseId, userId, content, date);
        return res > 0;
    }

    @Override
    public int getSelectCourseCounts(int courseId) throws Exception {
        return studyCenterMapper.getSelectCourseNumByCourseId(courseId);
    }
}
