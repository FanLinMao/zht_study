package cn.edu.cuit.study.web.manager;

import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.entity.Course;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.service.impl.CourseManageService;
import cn.edu.cuit.study.service.impl.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.edu.cuit.study.constant.SessionNames.SESSION_KEY_USER;

/**
 * @author Jayl1n
 * @date 2019/6/4 15:46
 */
@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {

    @Autowired
    ManagerService managerService;

    @Autowired
    CourseManageService courseManageService;

    /**
     * 查看管理员个人信息
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getPersonalProfile(Model model) {
        String userId = getCookieValue(SESSION_KEY_USER);
        User managerProfile = managerService.getManagerProfile(userId);
        if (managerProfile == null) {
            return "login.html";
        }
        String userName = managerProfile.getUserName();
        String userID = String.valueOf(managerProfile.getUserID());
        System.out.println(userName);
        System.out.println(userID);
        model.addAttribute("userName", userName);
        model.addAttribute("userID", userID);
        model.addAttribute("gender", managerProfile.getGender());
        model.addAttribute("phone", managerProfile.getPhone());
        model.addAttribute("birth", managerProfile.getBirth());
        return "manager/profile";
    }

    /**
     * 修改管理员个人信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ResponseBody
    public boolean updatePersonalProfile(@RequestBody User user) {
        String userId = getCookieValue(SESSION_KEY_USER);
        return userId.equals(user.getUserID()) && managerService.updateManagerProfile(user);
    }


    /**
     * 查看所有课程
     *
     * @param model
     * @return
     */
    @RequestMapping("/course")
    public String course(Model model) {
        List<Course> courses = courseManageService.selectAllCourse();
        model.addAttribute("course", courses);
        return "manager/course";
    }

    /**
     * 统计课程信息
     *
     * @param cid
     * @return
     */
    @RequestMapping("/course/analysis")
    @ResponseBody
    public Course analysisCourse(@RequestParam("cid") String cid) {
        return courseManageService.selectCourseById(cid);
    }


    /**
     * 管理员发布课程
     *
     * @return
     */
    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean addCourse() {
        String courseName = getParameter("courseName");
        String content = getParameter("content");
        String teacherName = getParameter("teacherName");
        int categoryid = Integer.parseInt(getParameter("categoryid"));
        int selectNum = Integer.parseInt(getParameter("selectNum"));
        String updatetime = getParameter("updatetime");

        Course course = new Course();
        course.setCourseName(courseName);
        course.setContent(content);
        course.setTeacherName(teacherName);
        course.setCategoryid(categoryid);
        course.setSelectNum(selectNum);
        course.setUploadtime(updatetime);

        return courseManageService.addCourse(course);
    }


    /**
     * 管理员删除课程
     *
     * @return
     */
    @RequestMapping(value = "/course/remove", method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteCourse() {
        String courseId = getParameter("courseId");
        return courseManageService.deleteCourseById(courseId);
    }

}