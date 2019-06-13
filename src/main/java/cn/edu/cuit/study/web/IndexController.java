package cn.edu.cuit.study.web;

import cn.edu.cuit.study.dao.CourseMapper;
import cn.edu.cuit.study.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 首页处理
 * @author Flemming
 */
@Controller
public class IndexController {

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("/index.html")
    public String index(){
        return "index";
    }

    @GetMapping("/getAllCourse")
    @ResponseBody
    public List<Course> getAllCourse(){
        List<Course> courses = courseMapper.selectAllCourse();
        return courses;
    }

    @PostMapping("/submitSearch")
    public List<Course> getSearchCoure(String search){
        List<Course> courses = courseMapper.selectCourseBySearch(search);
        return courses;
    }

}
