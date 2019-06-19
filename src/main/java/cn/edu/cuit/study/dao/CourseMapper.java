package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.Course;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper {

    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);


    Course selectByPrimaryKey(Integer courseid);


    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectAllCourse();

    List<Map> selectCourseBySearch(@Param("search") String search);
}