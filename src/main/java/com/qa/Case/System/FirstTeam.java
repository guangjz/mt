package com.qa.Case.System;

import net.sf.json.JSONObject;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by guangjiazheng on 2019/3/7.
 */
public class FirstTeam {

    public static final String url = "http://112.35.10.220:9090/openapi/V1/partner/ability/production/FirstTeam";

    @Test
    public static void FirstTeam_qa() throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(FirstTeam.url);

        // 设置请求的header
//        httpPost.addHeader("Authorization", HostAddress.QA_Gateway_token);

        JSONObject jsonParam = new JSONObject();
        JSONObject pub1 = new JSONObject();
        pub1.put("origSource","ZQKF");
        pub1.put("homeSource","ZQMJ");
        pub1.put("requestNo","2018081015000702975");
        pub1.put("requestNoTime","20180810150007");
        pub1.put("bIPCode","MJ01001");

        JSONObject pub = new JSONObject();
        pub.put("pub",pub1.toString());

        JSONObject inputPara = new JSONObject();
        inputPara.put("bIPCode","MirrorFirstTeamReq");

        jsonParam.put("appId", "A2016120614401100003");
        jsonParam.put("timestamp", "20180810150007");
        jsonParam.put("messageId", "b61a16e7e6b54ff2a5e24b9658595cca");
        jsonParam.put("sessionId","506acd3faa054da1ad9d91d9e098f989");
        jsonParam.put("content",pub.toString());



        String fja = jsonParam.toString();
        System.out.println(fja);


        CloseableHttpResponse response = null;
        try {

        StringEntity entity = new StringEntity(fja);
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

        // 打印执行结果
//        JSONObject he = Judge.Return_value(FirstTeam.url,jsonObject);

    }

}
