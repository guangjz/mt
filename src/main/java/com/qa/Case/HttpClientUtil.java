package com.qa.Case;

/**
 * Created by guangjiazheng on 2019/5/15.
 */
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;
import java.util.Map.Entry;
/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientUtil {

    public String doPost(String url, Map<String, String> map, String charset) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
//            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {

        String url = "http://10.1.234.16:8018/geec-order/api/v1/common/sendGroup/queryUsers";
        String charset = "utf-8";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String httpOrgCreateTest = url + "redict/test.do";
        Map<String, String> createMap = new HashMap<String, String>();
        createMap.put("groupId", "265");
//        createMap.put("pass", "admin");
//        createMap.put("key", "@#!`\\\\\\\\");
//        createMap.put("value", "<>#$@#%^");
//        createMap.put("url", httpOrgCreateTest);
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest, createMap, charset);
        System.out.println("result:" + httpOrgCreateTestRtn);
    }

}


