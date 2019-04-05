package cn.zkf.controller;

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
}
