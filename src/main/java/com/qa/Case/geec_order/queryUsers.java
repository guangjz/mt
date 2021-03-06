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
 * Created by guangjiazheng on 2019/5/15.
 */
public class queryUsers {

    public static final java.lang.String url = "/geec-order/api/v1/common/sendGroup/queryUsers";

    @Test
//    @RequestBody
    public static void getSignList_qa() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost(HostAddress.QA_geecorder_ip+queryUsers.url);
        post.addHeader("Content-Type:","application/json;charset=UTF-8");
        post.addHeader("token",HostAddress.QA_geecorder_token);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("groupId", "356");

        StringEntity entity = new StringEntity(jsonParam.toString(), "UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        post.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(post);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
    }
}
