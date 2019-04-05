package cn.zkf.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 实现方法，处理异常的业务逻辑
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @param o 当前处理器对象
     * @param e 当前抛出的异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //获取到异常对象
        SysException se=null;
        if(e instanceof SysException){
            se=(SysException) e;
        }else{
            se=new SysException("对不起！系统正在维护！！！");
        }

        //创建ModelAndView对象
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("errmessage",se.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

