package com.qa.Case;

/**
 * Created by guangjiazheng on 2019/5/15.
 */

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Date;

public class httpclient {

    /*入参说明
    *
    * param url 请求地址
    * param jsonObject	请求的json数据
    * param encoding	编码格式
    *
    * */
    public static String jsonPost(String url, JSONObject jsonObject, String encoding) {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.addHeader("token","ZmVuZ3hpbmdjaGVuZDZkYjk4ZDE3ZGQ2N2ZlNjQxMjU0NmY2ZDdlYzAzMmNlNjkzMGY2OTE3ZDM3NTk1YTFiZDI3OWM5MzBkNzUwMw==");
        String response = null;
        try {
            StringEntity s = new StringEntity(jsonObject.toString());
            s.setContentEncoding(encoding);
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.toJSONString(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    public static void main(String[] args) {
        String result = "http://10.1.234.16:8018/geec-order/api/v1/common/sendGroup/queryUsers";

//        String result1 = "http://10.1.234.16:8018/geec-order/api/v1/common/sendGroup/queryUsers";

        //一个json数据的post请求
        //版本号
//        Integer apiVersion = Constants.APIVERSION;
        //时间戳
        Long txnDate = new Date().getTime();

        //封装json数据
        JSONObject obj = new JSONObject();
        obj.put("groupId", "356");
//        obj.put("txnDate", txnDate);

        //提交请求
        result = jsonPost("http://10.1.234.16:8018/geec-order/api/v1/common/sendGroup/queryUsers", obj, "utf-8");
        System.out.println(result);
        //当时在测试的时候，返回的参数会出现中文乱码。这个是因为返回的参数使用了Unicode编码。所以用json转一下就可以了。

//        JSONObject jsonObject = JSONObject.parseObject(result);
//        System.out.println(jsonObject.toString());
//         result = jsonObject.toJSONString();


        System.out.println("---------------------------------------------");

    }


    }
