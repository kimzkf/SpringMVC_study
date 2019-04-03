package cn.zkf.controller;

import cn.zkf.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
}
