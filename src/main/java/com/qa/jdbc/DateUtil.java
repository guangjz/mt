package com.qa.jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by guangjiazheng on 2019/1/15.
 */
public class DateUtil {

        public static String timeStamp2Date(String seconds,String format) {

            if(seconds == null || seconds.isEmpty() || seconds.equals("null")){

                return "";
            }if(format == null || format.isEmpty()){

                format = "yyyy-MM-dd HH:mm:ss";

            }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));

        }

        public static String date2TimeStamp(String date_str,String format){

            try {

                SimpleDateFormat sdf = new SimpleDateFormat(format);

                return String.valueOf(sdf.parse(date_str).getTime()/1000);

                } catch (Exception e) {

                e.printStackTrace();

                }

                 return "";
         }


}
