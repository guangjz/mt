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
 * Created by guangjiazheng on 2019/5/6.
 */
public class GetSignList {

    public static final java.lang.String url = "/ec-console/wechat/sign/getSignList";

    @Test
    public static void getSignList_qa() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost(HostAddress.QA_ECconsole_ip+GetSignList.url);
        post.addHeader("Content-Type:","application/x-www-form-urlencoded");
        post.addHeader("token",HostAddress.QA_ECconsole_token);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("pageNo", "1");
        jsonParam.put("pageSize", "10");
        jsonParam.put("status", "6");

        StringEntity entity = new StringEntity("pageNo=1&pageSize=10&status=6", "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("X-WWW-FORM-URLENCODED");
        post.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(post);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
    }
}
