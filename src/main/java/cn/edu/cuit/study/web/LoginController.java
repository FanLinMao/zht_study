package cn.edu.cuit.study.web;

import cn.edu.cuit.study.common.AuthCode;
import cn.edu.cuit.study.common.BaseController;
import cn.edu.cuit.study.constant.SessionNames;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.io.PrintWriter;

import static cn.edu.cuit.study.constant.RandomCode.RanCode;

/**
 * 登录注册模块控制层
 * author:zjj
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private LoginService LoginService;

    @RequestMapping(value = "/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/houtai")
    public String selectuser() {
        return "login/userinfo";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String code = request.getParameter("authcode");
        /*System.out.println("手机号为"+phone);
        System.out.println("手机号为"+password);
        System.out.println("手机号为"+code);*/
        User user;
        user = LoginService.Login2(phone);
        if(code.equals(1)){
            model.addAttribute("error2", "验证码错误！！");
            System.out.println("手机号phone为"+code);
            return "login";
        }else {
            if (user == null) {
                model.addAttribute("error", "该账户不存在！！");
                System.out.println("手机号passcvf为"+code);
                return "login";
            } else {
                if (user.getPassword().equals(password)) {
                    getSession().setAttribute(SessionNames.SESSION_KEY_USER, user);
                    if (user.getRole() != 1) {
                        model.addAttribute("user", user);
                        String uuid = user.getUserName() + "-" + user.getUserID();
                        Cookie sessionId = new Cookie("sessionId", uuid);
                        response.addCookie(sessionId);
                        return "redirect:/index.html";
                    } else {
                        model.addAttribute("admin", user);
                        String uuid = user.getUserName() + "-" + user.getUserID();
                        Cookie sessionId = new Cookie("sessionId", uuid);
                        response.addCookie(sessionId);
                        return "redirect:/manager/profile";
                    }
                } else {
                    model.addAttribute("error1", "密码错误!");
                    return "login";
                }
            }
        }
    }

    @RequestMapping(value = "/register.html")
    public String register() {
        return "register";
    }

    /**
     * 登出，不要再改了
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout(){
        getSession().removeAttribute(SessionNames.SESSION_KEY_USER);
        removeCookies();
        return "redirect:/index.html";
    }

    @RequestMapping(value = "/addregister", method = RequestMethod.POST)
    public String register(Model model, HttpServletRequest request) {
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setBirth(request.getParameter("birth"));
        user.setHead(null);
        user.setRole(0);
        user.setGender(request.getParameter("gender"));
        user.setUserID(RanCode());
        user.setPhone(request.getParameter("phone"));
        Boolean result = LoginService.Register(user);
        if (result.equals(true)) {
            model.addAttribute("user", user);
            //不用管，它会自动拦截到登陆页面
            return "redirect:/index.html";
        } else {
            model.addAttribute("adderror", "注册失败");
            return "register";
        }
    }

    @GetMapping("/getAuthCode")
    public void getAuthCode() {
        String authCode = AuthCode.getAuthCode();
        BufferedImage bufferedImage = AuthCode.getAuthImg(authCode);
        try {
            ImageIO.write(bufferedImage, "JPEG", getResponse().getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
