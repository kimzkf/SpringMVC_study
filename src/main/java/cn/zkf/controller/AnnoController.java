package cn.zkf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 常用注解
 */
@Controller
@RequestMapping(path = "/anno")
public class AnnoController {
    @RequestMapping(path = "/testRequestParams")
    public String testRequestParams(@RequestParam(value = "username") String name){
        System.out.println("testRequestParams执行了。。。");
        System.out.println(name);
        return  "success";
    }

    /**
     * 获取到请求体内容
     * @param name
     * @return
     */
    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody(required = true) String body){
        System.out.println("testRequestBody执行了。。。");
        System.out.println(body);
        return  "success";
    }
}
