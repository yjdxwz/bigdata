package com.it18zhang.kafkaconsumer.test;

import com.it18zhang.kafkconsumer.HDFSOutputStreamPool;
import com.it18zhang.kafkconsumer.MyFSDataOutputStream;
import com.it18zhang.kafkconsumer.StringUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 测试类
 */
public class Testhive {

    @Test
    public void testHive() throws IOException {
        String newMsg = null;
        String log = "s201|||192.168.231.1|||-|||01/Mar/2017:14:31:47 +0800|||GET /eshop/phone/iphone7.html HTTP/1.0|||200|||424|||-|||ApacheBench/2.3|||-" ;
        System.out.println(log);
        String[] arr = StringUtil.splitLog(log);

        //进行清洗
        String request = arr[4];
        String[] reqArr = request.split(" ");
        if (reqArr != null && reqArr.length == 3) {
            if (reqArr[1].endsWith(".html")) {
                newMsg = StringUtil.arr2Str(arr, ",");
            } else {
            }
        } else {
        }
        //主机名
        String hostname = StringUtil.getHostname(arr);
        //取出日期对象
        Date reqDate = StringUtil.str2Date(arr);
        //得到日历对象
        Calendar c = Calendar.getInstance();
        //设置Date时间
        c.setTime(reqDate);
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DAY_OF_MONTH);
        int h = c.get(Calendar.HOUR_OF_DAY);
        int mi = c.get(Calendar.MINUTE);

        //path
        String rawPath = "/user/hive/warehouse/eshop.db/logs/year=" + y
                + "/month=" + m
                + "/day=" + d
                + "/hour=" + h
                + "/minute=" + mi
                + "/" + hostname + ".log";
        try {
            //判断是否和上一次相同
            MyFSDataOutputStream out = (MyFSDataOutputStream) HDFSOutputStreamPool.getInstance().takeOutputStream(rawPath);
            //
            out.write(newMsg.getBytes());
            out.write("\r\n".getBytes());
            out.hsync();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
