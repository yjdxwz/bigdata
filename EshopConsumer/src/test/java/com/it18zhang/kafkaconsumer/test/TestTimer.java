package com.it18zhang.kafkaconsumer.test;

import org.junit.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试TimerTask守护线程，实现调度.
 */
public class TestTimer {
    @Test
    public void test1() throws Exception {
        new Timer().schedule(new TimerTask() {
            public void run() {
                System.out.println(new Date());
            }
        },1000,2000);
        while(true){
            Thread.sleep(5000);
        }
    }
}
