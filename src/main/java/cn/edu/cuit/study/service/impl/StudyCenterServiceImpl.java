package cn.edu.cuit.study.service.impl;

import cn.edu.cuit.study.dao.StudyCenterMapper;
import cn.edu.cuit.study.entity.Course;
import cn.edu.cuit.study.service.StudyCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Map> getSelectCourseByUserId(int userId) throws Exception {
        return studyCenterMapper.getSelectCourseByUserId(userId);
    }

    @Override
    public Course getCourseInfoByCourseId(int courseId) throws Exception {
        return studyCenterMapper.getCourseInfoByCourseId(courseId);
    }

    @Override
    public boolean addCourse(int courseId, int userId) throws Exception {
        int result = studyCenterMapper.addCourse(courseId, userId);

        return result > 0;
    }

    @Override
    public boolean removeCourse(int courseId, int userId) throws Exception {
        int result = studyCenterMapper.removeCourse(courseId, userId);
        return result > 0;
    }
}
