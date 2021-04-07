package com.gong.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gonghongyu
 * @title: DataConvert
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/921:13
 **/
public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
