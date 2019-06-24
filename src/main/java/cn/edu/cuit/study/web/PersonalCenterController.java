package cn.edu.cuit.study.web;


import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.dao.PersonalCenterMapper;
import cn.edu.cuit.study.dto.Result;
import cn.edu.cuit.study.entity.Learning;
import cn.edu.cuit.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
        if (isCookie("sessionId")){
            return "login";
        }
        String[] split = getCookieValue("sessionId").split("-");
        model.addAttribute("userId",split[1]);
        model.addAttribute("userName",split[0]);

        return "personal";
    }


    /**
     * 返回用户的个人信息
     * @param userId 用户id
     * @return 用户信息
     */
    @RequestMapping(value = "/get/userInform",method = RequestMethod.GET)
    @ResponseBody
    public Result<User> personalInformation(int userId) {
        User user = pcm.getUser(userId);
        return new Result<>(true,user);
    }

    /**
     * 更新用户个人信息
     * @param user 表单数据绑定到user上
     * @return
     */
    @RequestMapping(value = "/update/userInform", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePersonalInformation(User user) {
        int i = pcm.updateByUser(user);

        if (i > 0) {
           return new Result<User>(true,"修改成功");
        }else {
           return new Result<User>(false,"修改失败");
        }
    }

    /**
     * 返回指定用户的历史记录
     * @param userId 用户id
     * @return 历史记录
     */
    @RequestMapping("/get/History")
    @ResponseBody
    public Result<List> getHistory(int userId){
        return new Result<>(true,pcm.getAllHistory(userId));
    }


    /**
     * 获取该用户的所有课程信息
     * @param userId 用户id
     * @return 返回结果
     */
    @RequestMapping("/get/Course")
    @ResponseBody
    public Result<List> getCourse(int userId) {

        List<Learning> allCourse = pcm.queryByUserId(userId);
        return new Result<>(true,allCourse);
    }
}
