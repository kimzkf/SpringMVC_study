package cn.zkf.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换为日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     *
     * @param s 传入进来的字符串
     * @return
     */
    @Override
    public Date convert(String s) {
        //判断
        if(s==null){
            throw new RuntimeException("请传入日期数据！");
        }
        //设置格式
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        //将字符串转为日期，抛异常提示ctrl+alt+t
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("日期数据格式错误！！！");
        }
    }
}
