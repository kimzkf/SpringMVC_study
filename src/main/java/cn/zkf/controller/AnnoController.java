package cn.zkf.controller;

import cn.zkf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    /**
     * PathVariable占位符注解
     * @return
     */
    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testpathVaribale(@PathVariable(name = "sid") String id){
        System.out.println("testPathVariable执行了。。。");
        System.out.println(id);
        return  "success";
    }
    /**
     * CookieValue:获取cookie的值
     * @return
     */
    @RequestMapping(path = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("testCookieValue执行了。。。");
        System.out.println(cookieValue);
        return  "success";
    }
    /**
     * ModelAttribute:showUser先执行
     * @return
     */
    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了。。。");
        System.out.println(user);
        return  "success";
    }

    /**
     * ModelAttribute该方法先执行
     */
    @ModelAttribute
    public User  showUser(String username){
        System.out.println("showUser执行了。。。");
        //通过用户查询数据库（模拟）
        User user=new User();
        user.setUsername(username);
        user.setPassword("123");
        user.setDate(new Date());
        return user;
    }
}
