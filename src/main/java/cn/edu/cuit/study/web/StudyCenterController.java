package cn.edu.cuit.study.web;

import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.common.MessageResult;
import cn.edu.cuit.study.constant.ResponseCode;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.service.StudyCenterService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @date: 2019/5/31
 * @author: Flemming
 * @description: 学习中心模块控制层
 */
@Controller
@RequestMapping("/studycenter")
public class StudyCenterController extends BaseController {

    @Autowired
    private StudyCenterService studyCenterService;


    @GetMapping("/index")
    public String studyIndex(){
        return "studyCenter";
    }

    /**
     * 获取用户选课信息
     * @return
     */
    @GetMapping("/getSelectCourseInfo")
    @ResponseBody
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

    /**
     * 添加笔记
     * @param courseId
     * @param note
     */
    @PostMapping("/addNote")
    @ResponseBody
    public void addNote(String courseId,String note){
        //User currentUser = getCurrentUser();
        try {
            boolean success = studyCenterService.addCourseNote(Integer.parseInt(courseId), Integer.parseInt("20001"), note);
            responseResult(success, "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 选课
     * @param courseId
     */
    @PostMapping("/addCourse")
    @ResponseBody
    public void addCourse(String courseId){
        User currentUser = getCurrentUser();
        try {
            boolean success = studyCenterService.addCourse(Integer.valueOf(courseId), Integer.valueOf(currentUser.getUserID()));
            responseResult(success, "选课成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加评论
     * @param courseId
     * @param commentContent
     */
    @PostMapping("/addComment")
    @ResponseBody
    public void addComment(String courseId, String commentContent){
        User currentUser = getCurrentUser();
        try {
            boolean success = studyCenterService.addCourseComment(Integer.valueOf(courseId), Integer.valueOf(currentUser.getUserID()), commentContent);
            responseResult(success, "添加评论成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void responseResult(boolean success, String message) throws Exception {
        getResponse().setCharacterEncoding("UTF-8");
        getResponse().setContentType("application/json; charset=utf-8");
        if (success){
            getResponse().getWriter().write(message);
        }else {
            getResponse().getWriter().write("Excute failed.");
        }
    }


}
