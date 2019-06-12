package cn.edu.cuit.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2019/5/15
 * @author: Flemming
 * @description:
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello Springboot";
    }

}
