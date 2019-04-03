package cn.zkf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
public class HelloController {
//RequestMapping:请求映射
//返回success,默认表示当前jsp文件的名字
    @RequestMapping(path = "/hello")
        public String sayHello(){
            System.out.println("say hello!");
            return "success";
        }
}
