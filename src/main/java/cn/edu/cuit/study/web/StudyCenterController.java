package cn.edu.cuit.study.web;

import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.common.MessageResult;
import cn.edu.cuit.study.constant.ResponseCode;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.service.StudyCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @date: 2019/5/31
 * @author: Flemming
 * @description: 学习中心模块控制层
 */
@RestController
@RequestMapping("/studycenter")
public class StudyCenterController extends BaseController {

    @Autowired
    private StudyCenterService studyCenterService;


    @GetMapping("/getSelectCourseInfo")
    public MessageResult getSelectCoursesInfo(){
        //获取到当前用户
        User user = getCurrentUser();
        MessageResult ms = null;
        try {
            //通过当前用户的ID查询选课信息
            List<Map> data = studyCenterService.getSelectCourseByUserId(user.getUserID());
            ms = new MessageResult("查看选课信息成功！", ResponseCode.SUCCESS, data);
        } catch (Exception e) {
            ms = new MessageResult("查看选课信息失败！", ResponseCode.FAILURE, "");
            e.printStackTrace();
        }
        return ms;
    }

}
