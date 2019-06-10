package cn.edu.cuit.study.web;


import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.constant.FilePath;
import cn.edu.cuit.study.constant.SessionNames;
import cn.edu.cuit.study.dao.PersonalCenterMapper;
import cn.edu.cuit.study.entity.Course;
import cn.edu.cuit.study.entity.CourseDownload;
import cn.edu.cuit.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.util.List;

/**
 * 个人中心
 * @author hl
 */
@RequestMapping("/personal")
public class PersonalCenterController extends BaseController {

    @Autowired
    PersonalCenterMapper pcm;

    @RequestMapping("/index")
    public String index(){
        return "personal";
    }

    @RequestMapping("/get/information")
    public String personalInformation(Model model) {
        String cookieValue = getCookieValue(SessionNames.SESSION_KEY_USER);
        if (cookieValue == null) {
            return "login";
        }
        User user = pcm.getUser();
        model.addAttribute("user", user);
        return "information";
    }

    @RequestMapping(value = "/update/information", method = RequestMethod.POST)
    public String updatePersonalInformation(User user, Model model) {
        String cookieValue = getCookieValue(SessionNames.SESSION_KEY_USER);
        if (cookieValue == null) {
            return "login";
        }
        int i = pcm.updateByUser(user);
        if (i > 0) {
            model.addAttribute("user",user);
            model.addAttribute("message","更新成功");
            return "information";
        }
        User oldUser = pcm.getUser();
        model.addAttribute("user",oldUser);
        model.addAttribute("message","更新失败");
        return "information";
    }

    @RequestMapping("/get/Course")
    public String getCourse(Model model) {
        String cookieValue = getCookieValue(SessionNames.SESSION_KEY_USER);
        if (cookieValue == null) {
            return "login";
        }

        List<Course> allCourse = pcm.getAllCourse();
        model.addAttribute("allCourse",allCourse);
        return "course";
    }


    @RequestMapping("/download/{userId}")
    public String downloadCourse(@PathVariable(value = "userId") int userId, Model model){
        if (getCookieValue(SessionNames.SESSION_KEY_USER) == null){
            return "login";
        }
        List<CourseDownload> courseDownloads = pcm.queryCourseDownload(userId);
        model.addAttribute("courseDownloads",courseDownloads);
        return "download";
    }
}
