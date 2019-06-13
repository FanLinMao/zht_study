package cn.edu.cuit.study.web;


import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.dao.PersonalCenterMapper;
import cn.edu.cuit.study.dto.Result;
import cn.edu.cuit.study.entity.Course;
import cn.edu.cuit.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 个人中心
 * @author hl
 */
@Controller
@RequestMapping("/personal")
public class PersonalCenterController extends BaseController {

    @Autowired
    PersonalCenterMapper pcm;

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        String sessionId = getCookieValue("sessionId");
        String[] split = sessionId.split("-");
        model.addAttribute("userId",split[1]);
        model.addAttribute("userName",split[0]);
        if ("".equals(sessionId)){
            return "login";
        }
        return "personal";
    }


    @RequestMapping(value = "/get/userInform",method = RequestMethod.GET)
    @ResponseBody
    public Result<User> personalInformation(@RequestParam(value = "userId")int userId) {
        String sessionId = getCookieValue("sessionId");
        if ("".equals(sessionId)){
            return new Result<>(false,"请选登录");
        }
        User user = pcm.getUser(userId);
        return new Result<>(true,user);
    }

    @RequestMapping(value = "/update/userInform", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePersonalInformation(User user, Model model) {
        String sessionId = getCookieValue("sessionId");
        if ("".equals(sessionId)) {
            return new Result<>(false,"请先登录");
        }
        int i = pcm.updateByUser(user);

        if (i > 0) {
           return new Result<User>(true,"修改成功");
        }else {
           return new Result<User>(false,"修改失败");
        }
    }

    @RequestMapping("/get/Course")
    public Result<List> getCourse(@RequestParam(value = "userId")int userId,Model model) {
        String sessionId = getCookieValue("sessionId");
        if ("".equals(sessionId)) {
            return new Result<>(false,"请先登录");
        }

        List<Course> allCourse = pcm.getAllCourse(userId);
        return new Result<>(true,allCourse);
    }
}
