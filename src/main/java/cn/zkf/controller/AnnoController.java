package cn.zkf.controller;

import cn.zkf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */
@Controller
@RequestMapping(path = "/anno")
@SessionAttributes(value = {"msg"})//把msg=hello存入到session域中
public class AnnoController {
    @RequestMapping(path = "/testRequestParams")
    public String testRequestParams(@RequestParam(value = "username") String name){
        System.out.println("testRequestParams执行了。。。");
        System.out.println(name);
        return  "success";
    }

    /**
     * 获取到请求体内容
     * @param
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
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了。。。");
        System.out.println(user);
        return  "success";
    }
    /**
    * ModelAttribute该方法先执行（无返回值）
    */
    @ModelAttribute
    public void  showUser(String username, Map<String,User> map){
        System.out.println("showUser执行了。。。");
        //通过用户查询数据库（模拟）
        User user=new User();
        user.setUsername(username);
        user.setPassword("123");
        user.setDate(new Date());
        map.put("abc",user);
    }
    /**
     * ModelAttribute该方法先执行（有返回值）
     */
    /*@ModelAttribute
    public User  showUser(String username){
        System.out.println("showUser执行了。。。");
        //通过用户查询数据库（模拟）
        User user=new User();
        user.setUsername(username);
        user.setPassword("123");
        user.setDate(new Date());
        return user;
    }*/

    /**
     * SessionAttribute注解
     */
    @RequestMapping(path = "/testSessionAttribute")
    public String  testSessionAttribute(Model model){
        System.out.println("testSessionAttribute执行了。。。");
        //底层会存储到request域对象当中
        model.addAttribute("msg","hello");
        return  "success";
    }
    //获取session域内容
    @RequestMapping(path = "/getSessionAttribute")
    public String  getSessionAttribute(ModelMap modelMap){
        System.out.println("getSessionAttribute。。。");
       String str=(String) modelMap.get("msg");
        System.out.println(str);
        return  "success";
    }
    //删除session域内容
    @RequestMapping(path = "/delSessionAttribute")
    public String  delSessionAttribute(SessionStatus sessionStatus){
        System.out.println("delSessionAttribute。。。");
        sessionStatus.setComplete();
        return  "success";
    }
}
