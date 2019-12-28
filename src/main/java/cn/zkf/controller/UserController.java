package cn.zkf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping(path = "/uc")
public class UserController {
    /**
     * 拦截器
     * @return
     */
    @RequestMapping(path = "/testInterceptor")
    public  String testInterceptor(){
        System.out.println("testInterceptor。。。。。");
        return "success";
    }
}
