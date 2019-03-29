package com.qa.Case.Public;

import net.sf.json.JSONObject;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by guangjiazheng on 2019/3/12.
 */
public class HttpPost {

    public static void topost (String url,String date) throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();

        org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(url);

        CloseableHttpResponse response = null;
        try {

            StringEntity entity = new StringEntity(date);
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(entity);

            // 执行请求
            response = httpClient.execute(httpPost);
            String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
            JSONObject jsonObject = JSONObject.fromObject(json2);
            System.out.println(jsonObject);


        } catch (ClientProtocolException e) {
            System.err.println("Http协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("解析错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        } finally {
            // 释放连接

            if (null != response) {
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    System.err.println("释放连接出错");
                    e.printStackTrace();
                }
            }


        }

    }
}
