package com.it18zhang.kafkconsumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * |是正则表示特殊字符
     */
    private static final String token = "\\|\\|\\|" ;

    /**
     * 切割单行日志
     */
    public static String[] splitLog(String log){
        String[] arr = log.split(token);
        return arr ;
    }

    public static String getHostname(String[] arr){
        return arr[0];
    }

    /**
     *返回 2017/02/28/12/12
     */
    public static String formatYyyyMmDdHhMi(String[] arr){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
            Date d = sdf.parse(arr[3].split(" ")[0]);
            SimpleDateFormat localSDF = new SimpleDateFormat("yyyy/MM/dd/HH/mm", Locale.US);
            return localSDF.format(d);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    /**
     * 将数组转换成字符串，使用token作为分隔符
     */
    public static String arr2Str(Object[] arr,String token){
        String str = "" ;
        for(Object o : arr){
            str = str  + o + token ;
        }
        return str.substring(0,str.length() - 1) ;
    }

    /**
     * 将字符串转成日期对象
     */
    public static Date str2Date(String[] arr){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
            Date d = sdf.parse(arr[3].split(" ")[0]);
            return d ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
