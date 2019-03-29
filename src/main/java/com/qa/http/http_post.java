package com.qa.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import sohuadx.WriteLog;

import java.io.IOException;
import java.util.Map;

/**
 * Created by guangjiazheng on 2018/12/14.
 */
public class http_post {

    final public static String  filePath4=".//src//responsetime.txt";

    @Test
    public static String doHttpPost(String url, Map<String, Object> paras){
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String jsonResult = null;
        long starttime = 0;
        long endtime = 0;
        HttpPost method = new HttpPost(url);
//        method.addHeader("Content-Type", "application/json;charset=utf-8");
        try {
//            method.setEntity(new UrlEncodedFormEntity((List<? extends NameValuePair>) paras,HTTP.UTF_8));
            starttime = System.currentTimeMillis();
            HttpResponse result = httpClient.execute(method);
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                endtime = System.currentTimeMillis();
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());

                    /**把json字符串转换成json对象**/
                    jsonResult = str;
                    //System.out.println(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long timedifer = endtime - starttime;

        WriteLog.writeIntoFile("Response响应时间：  " + timedifer + "毫秒", http_post.filePath4, true);

        return jsonResult;

    }

}
