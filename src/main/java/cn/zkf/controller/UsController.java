package cn.zkf.controller;

import cn.zkf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping(path = "/us")
public class UsController {
    /**
     * 返回值字符串
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/testResponseString")
    public String testResponseString(Model model) {
        System.out.println("testResponseString...");
        //模拟查询数据
        User user = new User();
        user.setUsername("123");
        user.setPassword("hhh");
        user.setDate(new Date());
        //model对象
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 无返回值void
     * 请求转发一次请求，不用编写项目名称
     *
     * @param
     * @return
     */
    @RequestMapping(path = "/testResponseVoid")
    public void testResponseVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testResponseVoid...");
        //编写请求转发程序
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向程序,2次请求
        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接会进行响应
        response.getWriter().print("hello");
        return;
    }

    /**
     * 返回ModelAndView对象
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testModelAndView(Model model) {
        System.out.println("testModelAndView...");
        ModelAndView modelAndView = new ModelAndView();
        //模拟查询数据
        User user = new User();
        user.setUsername("176543");
        user.setPassword("hhh");
        user.setDate(new Date());

        //把user对象存入到ModelAndView对象中，也会把user对象存入到request对象
        modelAndView.addObject("user", user);

        //设置跳转页面,用了视图解析器
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 使用关键字的方式进行转发或重定向
     *
     * @param
     * @return
     */
    @RequestMapping(path = "/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect...");

        //请求的转发
        //return "forward:/WEB-INF/pages/success.jsp";

        //请求的重定向;重定向不能访问WEB-INF下的目录文件
        return "redirect:/index.jsp";
    }

    /**
     * 模拟ajax异步与响应
     * RequestBody:获得请求体内容
     * ResponseBody:响应自动转json
     */
    @RequestMapping(path = "/testAjax")
    public @ResponseBody
    User testAjax(@RequestBody User user) {
        System.out.println("testAjax...");

        //客户端发送ajax请求，传的json字符串，后端已经把json字符串封装进user对象中
        System.out.println(user);

        //作响应，模拟数据库查询
        user.setUsername("haha");
        user.setDate(new Date());
        return user;
    }

}
