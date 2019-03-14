package com.qa.Case.CustomerService;

import com.qa.Case.Public.HostAddress;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guangjiazheng on 2019/3/14.
 */
public class Desk {

    public static final String url = "http://112.35.22.232:8011/geec-order/api/v1/order/desk";

    @Test
    public static  void Desk_qa() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(Desk.url);

        // 设置请求的header
        httppost.addHeader("Content-Type", "application/json");
        httppost.addHeader("token", HostAddress.QA_Governmenty_token);
        // 设置请求的参数
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("orderTitle", "Gjz自动化测试数据");
        jsonParam.put("busiTypeId", "5");
        jsonParam.put("customerInfo", "Gjz自动化测试数据");
        jsonParam.put("contentDesc","Gjz自动化测试数据");
        List<String> ls = new ArrayList<String>();
        ls.add("1");
        jsonParam.put("attachIds",ls);
        jsonParam.put("taskTypeId","1");
        jsonParam.put("targetsysId","1");
        jsonParam.put("funcmodId","6");
        jsonParam.put("timeLimit","0.6");
        jsonParam.put("keyInfo","Gjz自动化测试数据");
        jsonParam.put("issueProvince","1");
        jsonParam.put("issueSource","2");
        jsonParam.put("issueProposer","测试");
        jsonParam.put("issueProposerPhone","15694119662");
        jsonParam.put("issueDept","测试");
        jsonParam.put("issueProposeTime","2019-03-26 00:00:00");
        jsonParam.put("starterName","兰学兴");
        jsonParam.put("starterDept","业务支撑领导组");
        jsonParam.put("starterPhone","18311376637");
        jsonParam.put("starterId","379");
        StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("X-WWW-FORM-URLENCODED");
        httppost.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(httppost);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
        JSONObject result = (JSONObject) jsonObject.get("result");
//        String orderId = (String)result.get("orderId");
        System.out.println(result.get("orderId"));
    }


}
