package com.qa.Case.System;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * Created by guangjiazheng on 2018/12/28.
 */
public class GetUserMenuList {

//    public static final String url = "/api/user/topMsgList";


    @Test
    public static void GetSoftClassList() throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "http://112.35.22.232:8025/ec-console/sys/menu/getUserMenuList";
        String date = "";
        String token = "a270f8baa0ea5ab7334d8f32c3d42256";
        HttpPost httpPost = new HttpPost(url);

        // 设置请求的header
        httpPost.addHeader("Content-Type","application/json");


        // 设置请求的参数
//        Map<String, Object> jsonParam = new HashMap<String, Object>();
//        JSONObject jsonParam = new JSONObject();
//        jsonParam.put("userId",userId);
//
//        jsonParam.put("count",5);

        System.out.println(date);
        StringEntity entity = new StringEntity(date);
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
//        jsonStr.replaceAll.（"\\\\","")

        char str[] = json2.toString().toCharArray();

        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");

        }


//        JSONObject obj2 = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);


        // 打印执行结果

    }
}
