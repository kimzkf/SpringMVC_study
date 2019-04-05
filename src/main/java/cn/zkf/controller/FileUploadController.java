package cn.zkf.controller;

import cn.zkf.exception.SysException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(path = "/fileUp")
public class FileUploadController {
    /**
     * springmvc文件上传demo
     * MultipartResolver upload,参数名与jsp中文件name一致
     * @return
     */
    @RequestMapping(path = "/fileUpload1")
    public String fileUpload1(HttpServletRequest request, MultipartFile upload){
        System.out.println("springmvc文件上传了。。。。。");

        //使用upload组件完成文件上传
        //上传位置
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file=new File(path);
        //不存在
        if (!file.exists()){
            //创建
            file.mkdirs();
        }

        //说明上传文件项
        //获取上传文件名称
        String fileName=upload.getOriginalFilename();
        //把名称改为唯一值
        String uuid=UUID.randomUUID().toString().replace("-","");
        fileName=uuid+"_"+fileName;
        //完成文件上传
        try {
            upload.transferTo(new File(path,fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }

    /**
     * 跨服务器上传文件
     * @param request
     * @param upload
     * @return
     */
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("springmvc跨服务器上传文件。。。。。");

        //使用upload组件完成文件上传
        //上传位置
        String path="http://localhost:9090/uploads/";
        //判断，该路径是否存在
        File file=new File(path);
        //不存在
        if (!file.exists()){
            //创建
            file.mkdirs();
        }

        //说明上传文件项
        //获取上传文件名称
        String fileName=upload.getOriginalFilename();
        //把名称改为唯一值
        String uuid=UUID.randomUUID().toString().replace("-","");
        fileName=uuid+"_"+fileName;

        //创建客户端对象
        Client client=Client.create();
        //和文件服务器进行连接
       WebResource webResource=client.resource(path+fileName);

       //上传文件
        webResource.put(upload.getBytes());

        return "success";
    }

    /**
     *异常处理
     * @return
     */
    @RequestMapping(path = "/testException")
    public String testException() throws Exception{
        try {
            //模拟异常
            int i=10/0;
        } catch (Exception e) {
            //控制台打印异常信息
            e.printStackTrace();
            throw new SysException("查询所有用户错误。。。");
        }
        return "success";
    }

}
