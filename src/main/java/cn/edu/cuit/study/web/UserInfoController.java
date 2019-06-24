package cn.edu.cuit.study.web;

import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.service.UserInfoService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static cn.edu.cuit.study.constant.RandomCode.RanCode;

/**
 * author:zjj
 * 用户信息管理 控制层
 */
@RestController
@RequestMapping(value="/userinfo")
public class UserInfoController extends BaseController {

    @Autowired
    public UserInfoService UserInfoService;

    /**
     * 显示所有用户信息
     * @return json
     */
    @RequestMapping(value="/selectuser")
    public Object selectuser() {
        List<User> userList =UserInfoService.selectUser();
        return JSON.toJSON(userList);
    }

    /**
     * 添加新用户
     * @param userName
     * @param password
     * @param gender
     * @param birth
     * @param phone
     * @return String
     */
    @RequestMapping(value="/adduser",method = RequestMethod.POST)
    public String adduser(String userName,String password,String gender,String birth,String phone) {
        System.out.println("adduser 获取的userName为"+userName);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(birth);
        System.out.println("adduser 获取的phone为"+phone);
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setBirth(birth);
        user.setHead(null);
        user.setRole(0);
        user.setGender(gender);
        user.setUserID(RanCode());
        user.setPhone(phone);
        System.out.println("adduser 获取的userName为" + user.getUserName());
        Boolean result = UserInfoService.addUser(user);
        return result.toString();

    }

    /**
     * 删除指定用户
     * @param request
     */
    @RequestMapping(value="/deleteuser",method = RequestMethod.POST)
    public void deleteuser(HttpServletRequest request) {
        int userID = Integer.parseInt(request.getParameter("userID"));
        System.out.println("需要删除的id为"+userID);
        Boolean result = UserInfoService.deleteUser(userID);
        System.out.println("删除"+result);
    }

    /**
     * 更新指定用户信息
     * @param userID
     * @param userName
     * @param password
     * @param gender
     * @param birth
     * @param phone
     * @return
     */
    @RequestMapping(value="/updateuser",method = RequestMethod.POST)
    public String updateuser(String userID,String userName,String password,String gender,String birth,String phone) {
        User user = new User();
        System.out.println("updateuser 获取的userID为：" + Integer.parseInt(userID));
        System.out.println("updateuser 获取的userName为"+userName);
        user.setUserName(userName);
        user.setPassword(password);
        user.setBirth(birth);
        user.setUserID(Integer.parseInt(userID));
        user.setGender(gender);
        user.setPhone(phone);
        user.setHead(null);
        Boolean result = UserInfoService.updateUser(user);
        if(result.equals(true)){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }

    /**
     * 查找单个用户信息
     * @param request
     * @return
     */
    @RequestMapping(value="/finduser",method = RequestMethod.POST)
    public Object finduser(HttpServletRequest request) {
        int userID = Integer.parseInt(request.getParameter("userID"));
        User user = UserInfoService.findUser(userID);
        System.out.println("查询到的 数据——————————" + user.getUserName());
        return JSON.toJSON(user);
    }
}
