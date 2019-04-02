package com.qa.Case.EC_Console;

import com.qa.Case.Public.HostAddress;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * Created by guangjiazheng on 2019/3/29.
 */
public class getUserMenuList {

    public static final String url = "/ec-console/sys/menu/getUserMenuList";

    @Test
    public static void getUserMenuList_qa() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost(HostAddress.QA_ECconsole_url+getUserMenuList.url);
        post.addHeader("Content-Type:","application/json");
        post.addHeader("token",HostAddress.QA_ECconsole_token);

        StringEntity entity = new StringEntity(HostAddress.QA_Governmenty_null_value, "utf-8");

        entity.setContentEncoding("UTF-8");
        entity.setContentType("X-WWW-FORM-URLENCODED");
//        HttpGet.setCancellable((Cancellable) entity);

        // 执行请求

        HttpResponse response = httpClient.execute(post);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
    }
}
