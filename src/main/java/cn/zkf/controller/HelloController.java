package cn.zkf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//RequestMapping类上，/user/hello,可以分模块
//控制器类
@Controller
@RequestMapping(path = "/user")
public class HelloController {
//RequestMapping:请求映射,path和value都是映射地址;
//method：当前方法接收请求方式,是一个数组
//params:用于指定限制请求参数的条件。它支持简单表达式。要求请求参数key和value必须配置的一模一样.
// 如params ={"username"}，请求中必须传username,params ={"username=hehe"}:前端传过来必须key和value一致
//返回success,默认表示当前jsp文件的名字
    @RequestMapping(path = "/hello",method = {RequestMethod.GET,RequestMethod.POST},params ={"username"} )
        public String sayHello(){
            System.out.println("say hello!");
        System.out.println("username");
            return "success";
        }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path = "/testRequestMapping")
    public  String testRequestMapping(){
            System.out.println("testRequestMapping...");
            return "success";
        }
}
