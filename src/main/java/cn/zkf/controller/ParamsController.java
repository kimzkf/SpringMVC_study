package cn.zkf.controller;

import cn.zkf.domain.Account;
import cn.zkf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/params")
public class ParamsController {
    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping(path = "/testParams")
    public String testParams(String username){
        System.out.println("执行了。。。。");
        System.out.println("username="+username);
        return "success";
    }

    /**
     * params将参数封装为javaBean
     * @return
     */
    @RequestMapping(path = "/saveAccount")
    public  String saveAccount(Account account){
        System.out.println("执行了saveAccount。。。。");
        System.out.println(account.toString());
        return "success";
    }
    /**
     * params将参数封装类型转换,自定义类型转换器
     * @return
     */
    @RequestMapping(path = "/saveUser")
    public  String saveUser(User user){
        System.out.println("执行了saveUser。。。。");
        System.out.println(user.toString());
        return "success";
    }
    /**
     * servlet原生API获取
     * @return
     */
    @RequestMapping(path = "/testServlet")
    public  String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了testServlet。。。");
        System.out.println(request.getContextPath());
        return "success";
    }
}
