package com.it18zhang.kafkconsumer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 关闭线程池
 */
public class CloseFSOuputStreamTask extends TimerTask{
    public void run() {
        HDFSOutputStreamPool pool = HDFSOutputStreamPool.getInstance();
        pool.releasePool();
    }

    public static void main(String[] args) throws Exception
    {
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
