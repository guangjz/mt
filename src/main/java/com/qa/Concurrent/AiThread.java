package com.qa.Concurrent;

import com.qa.Case.CustomerService.Config;

/**
 * Created by guangjiazheng on 2018/12/14.
 */
public class AiThread implements Runnable{

    public AiThread() {

    }

    public void run() {
        try {

            Config.Device_qa();

        } catch (Exception var2) {

            var2.printStackTrace();
        }

    }

    public static void main(String[] args) throws Throwable {
        AiThread test = new AiThread();

        Thread thread [] = new Thread [100];

        long time1=System.currentTimeMillis();

        for(int i=0;i<20;i++){

            thread[i]=new Thread(test);

            thread[i].start();


        }

        long time2=System.currentTimeMillis();

        System.out.println("当前程序耗时："+(time2-time1)+"ms");

    }
}
