package cn.edu.cuit.study.web;

import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.dao.CourseMapper;
import cn.edu.cuit.study.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 首页处理
 * @author Flemming
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("/index.html")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        List<Course> courses = courseMapper.selectAllCourse();
        String split = getCookieValue("sessionId");
        model.addObject("userName",split.split("-")[0]);
        model.addObject("courses",courses);
        return model;
    }

    /*@GetMapping("/getAllCourse")
    @ResponseBody
    public List<Course> getAllCourse(){
        List<Course> courses = courseMapper.selectAllCourse();
        return courses;
    }*/

    @PostMapping("/index.html")
    public ModelAndView getSearchCoure(String searchContent){
        ModelAndView model = new ModelAndView("searchPage");
        List<Map> searchcourses = courseMapper.selectCourseBySearch(searchContent);
        model.addObject("searchcourses", searchcourses);
        return model;
    }

}
