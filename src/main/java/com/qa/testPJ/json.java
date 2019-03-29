package com.qa.testPJ;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * Created by guangjiazheng on 2018/12/5.
 */
public class json {

    @Test
    public static  void httpPost() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "http://112.35.81.139:18080/dmp/terminalNorthApi/device";
        String url2 = "http://120.27.13.239:8081/dmp/terminalNorthApi/device";
        HttpPost httpPost = new HttpPost(url);

        // 设置请求的header
//        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.addHeader("token", "c626611722c246cba17fdfe49ca317b2");

        // 设置请求的参数
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("deviceName", "哈哈");
        jsonParam.put("productId", "57700000693");
        jsonParam.put("terminalSN", "123445");
        jsonParam.put("customerId","ec_0327081");


        StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
    }




}
