package com.qa.testPJ;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guangjiazheng on 2018/12/5.
 */
public class TopMsgList {

    @Test
    public static  void TopMsgList() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "http://10.12.2.27:8080/api/user/getAuditStatusInfo";
//        String url = "http://10.12.2.27:8080/api/online/getProvinceList";
        String token = "62847701701aaa433ddc207dc80eb088";
//        String userId = "100097";
        HttpPost httpPost = new HttpPost(url);

        // 设置请求的header
        httpPost.addHeader("Authorization",token);


        // 设置请求的参数
        Map<String, String> maplist = new HashMap<String, String>();
        maplist = httpsend.rereadTxtFile("/Users/guangjiazheng/Downloads/meituancode/hellohttp/src/main/java/com/qa/date/ada");
//        jsonParam.put("userId","100097");

//        jsonParam.put("productId", "57700000152");

        System.out.println(maplist);
        StringEntity entity = new StringEntity(maplist.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
    }
}
