package cn.zkf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/params")
public class ParamsController {
    /**
     *
     * 请求参数绑定入门
     *
     * @return
     */
    @RequestMapping(path = "/testParams")
    public String testParams(String username){
        System.out.println("执行了。。。。");
        System.out.println("username="+username);
        return "success";
    }
}
