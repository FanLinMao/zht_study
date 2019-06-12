package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jayl1n
 * @date 2019/6/4 16:31
 */
@Repository
public interface CourseManageMapper {
    List<Course> selectAllCourse();

    boolean insertCourse(Course course);

    boolean deleteCourseById(int courseId);
}
