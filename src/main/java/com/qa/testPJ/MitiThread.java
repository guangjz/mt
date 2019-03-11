package com.qa.testPJ;

/**
 * Created by guangjiazheng on 2018/12/6.
 */
public class MitiThread implements Runnable {
//    MySqlTest xx = new MySqlTest();

    public MitiThread() {
    }

    public void run() {
        try {
            json.httpPost();
        } catch (Exception var2) {

            var2.printStackTrace();
        }

    }

    public static void main(String[] args) throws Throwable {
        MitiThread test = new MitiThread();
        Thread thread [] = new Thread [1000];

        long time1=System.currentTimeMillis();


        for(int i=0;i<100;i++){

            thread[i]=new Thread(test);

            thread[i].start();


        }


        long time2=System.currentTimeMillis();
        System.out.println("当前程序耗时："+(time2-time1)+"ms");

    }
}
