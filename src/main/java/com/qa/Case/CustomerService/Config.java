package com.qa.Case.CustomerService;

import com.qa.Case.Public.HostAddress;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by guangjiazheng on 2019/3/14.
 */
public class Config {


    public static final String url = "http://112.35.22.232:8011/geec-order/api/v1/common/config";
    @Test
    public static void Device_qa() throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet HttpGet = new HttpGet(Config.url);

        // 设置请求的header
        HttpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
        HttpGet.addHeader("token", HostAddress.QA_Governmenty_token);
        // 设置请求的参数
        long terminalSN = new Date().getTime();
        System.out.println(terminalSN);


        StringEntity entity = new StringEntity(HostAddress.QA_Governmenty_null_value, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("X-WWW-FORM-URLENCODED");
//        HttpGet.setCancellable((Cancellable) entity);

        // 执行请求
        HttpResponse response = httpClient.execute(HttpGet);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
    }

}
