package com.qa.Case.geec_order;

import com.qa.Case.Public.HostAddress;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * Created by guangjiazheng on 2019/5/23.
 */
public class newWorkSheet {

    public static final java.lang.String url = "/geec-order/api/v1/bomc/call/newWorkSheet";

    @Test
//    @RequestBody
    public static void getSignList_qa() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost(HostAddress.QA_geecorder_ip+newWorkSheet.url);
//        stringContent.Headers.ContentType = new MediaTypeWithQualityHeaderValue("application/json");

        post.addHeader("Content-Type:","application/json;charset=UTF-8");
//        post.addHeader("Content-Type:","text/plain;charset=UTF-8");

        post.addHeader("token",HostAddress.QA_geecorder_token);



        JSONObject jsonParam = new JSONObject();
        jsonParam.put("serialNo","20190402ZQKF0221585");
        jsonParam.put("attachRef","123");
        jsonParam.put("opDetail","123");
        StringEntity body = new StringEntity(jsonParam.toString(1));
        post.setEntity(body);


        System.out.println(jsonParam);


        StringEntity entity = new StringEntity(jsonParam.toString());
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        post.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(post);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(json2);
//        System.out.println(jsonObject);
    }
}
