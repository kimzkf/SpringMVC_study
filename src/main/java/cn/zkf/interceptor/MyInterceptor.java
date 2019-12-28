package cn.zkf.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器类，实现HandlerInterceptor接口
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 预处理，在controller方法执行前
     * return true：放行，执行下一个拦截器，如果没有，执行controller
     * return false：不放行，request或response调转到某页面，不执行下一个拦截器或执行controller
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       System.out.println("MyInterceptor预处理执行了。。。。。。。。");
       request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return false;
    }

    /**
     * 后处理方法，controller方法执行后，success.jsp执行之前
     * 如果进行跳转其他页面，success.jsp是执行的
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor后处理执行了。。。。。。。。");
    }

    /**
     *success.jsp执行后，该方法会执行
     * 不能跳转页面了
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor最后结束处理执行了。。。。。。。。");
    }
}
