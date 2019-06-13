package cn.edu.cuit.study.web;

import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.common.MessageResult;
import cn.edu.cuit.study.constant.ResponseCode;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.service.StudyCenterService;
import cn.edu.cuit.study.utils.PageBean;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
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

    private int courseID = 1001;//课程ID

    @GetMapping("/index")
    public String studyIndex(Model model,@RequestParam("courseId")int courseId){
        courseID = courseId;
        String sessionId = getCookieValue("sessionId");
        String[] split = sessionId.split("-");
        model.addAttribute("userName",split[0]);
        model.addAttribute("userId",split[1]);
        model.addAttribute("courseId",courseID);
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
    public String addNote(String courseId,String note){
        User currentUser = getCurrentUser();
        try {
            boolean success = studyCenterService.addCourseNote(courseID, currentUser.getUserID(), note);
            if (success){
                return "保存成功！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "保存失败！";
    }

    /**
     * 选课
     * @param courseId
     */
    @PostMapping("/addCourse")
    @ResponseBody
    public String addCourse(String courseId){
        User currentUser = getCurrentUser();
        try {
            boolean success = studyCenterService.addCourse(courseID, currentUser.getUserID());
            //responseResult(success, "选课成功！");
            if (success){
                return "选课成功！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "选课失败！";
    }

    /**
     * 退课
     * @param courseId
     * @return
     */
    @PostMapping("/removeCourse")
    @ResponseBody
    public String removeCourse(String courseId){

        User currentUser = getCurrentUser();
        try {
            boolean success = studyCenterService.removeCourse(courseID, currentUser.getUserID());
            if (success){
                return "退课成功！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "退课失败！";
    }


    /**
     * 添加评论
     * @param courseId
     * @param commentContent
     */
    @PostMapping("/addComment")
    @ResponseBody
    public String addComment(String courseId, String commentContent){
        User currentUser = getCurrentUser();
        try {
            boolean success = studyCenterService.addCourseComment(courseID, currentUser.getUserID(), commentContent);
            //responseResult(success, "添加评论成功！");
            if (success){
                return "发表成功！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "发表失败！";
    }
    @GetMapping("/getViews")
    @ResponseBody
    public PageBean<Map> getViews(int courseId, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo){
        PageBean<Map> page = null;
        try {
            page = studyCenterService.getReviewsByPage(1001, pageNo, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    /**
     * 浏览器响应后下载文件
     * @param response  http Response响应流
     * @param result 请求成功后 function(result)函数中的参数
     * @throws IOException
     */
    @RequestMapping("/download")
    public void download (HttpServletResponse response, String result) throws
            IOException {


        response.setCharacterEncoding("utf-8");

        String[] split = result.split("/");

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(split[2], "utf-8"));

        OutputStream os = response.getOutputStream();
        File file = new File(result);

        final int length = 1024 * 1024;
        ByteBuffer bytes = ByteBuffer.allocate(length);

        SeekableByteChannel seekByte = Files.newByteChannel(file.toPath());

        int readed = -1;
        while ((readed = seekByte.read(bytes)) >= 1) {
            os.write(bytes.array(), 0, readed);
            os.flush();
            bytes.clear();
        }

        IOUtils.closeQuietly(os);

    }

    /*private void responseResult(boolean success, String message) throws Exception {
        getResponse().setCharacterEncoding("UTF-8");
        getResponse().setContentType("application/json; charset=utf-8");
        if (success){
            getResponse().getWriter().write(message);
        }else {
            getResponse().getWriter().write("Excute failed.");
        }
    }*/


}
