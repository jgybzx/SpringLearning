package com.jgybzx.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: guojy
 * @date: 2019/12/30 13:29
 * @Description: ${TODO}
 * @version:
 */
public class MyConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = null;
        try {
            if (source.contains("/")) {
                simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            } else if (source.contains("-")) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
            date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            System.out.println("日期转换异常");
        }

        return date;
    }
}
