package cn.edu.cuit.study.service.impl;

import cn.edu.cuit.study.dao.CourseManageMapper;
import cn.edu.cuit.study.dao.CourseMapper;
import cn.edu.cuit.study.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jayl1n
 * @date 2019/6/4 16:29
 */
@Service
public class CourseManageService {

    @Autowired
    CourseManageMapper courseManageMapper;

    @Autowired
    CourseMapper courseMapper;

    public List<Course> selectAllCourse() {
        return courseManageMapper.selectAllCourse();
    }

    public boolean addCourse(Course course) {
        return courseManageMapper.insertCourse(course);
    }

    public boolean deleteCourseById(String courseId) {
        int cid = Integer.parseInt(courseId);
        return courseManageMapper.deleteCourseById(cid);
    }

    public Course selectCourseById(String s) {
        int cid = Integer.parseInt(s);
        return courseMapper.selectByPrimaryKey(cid);
    }
}
