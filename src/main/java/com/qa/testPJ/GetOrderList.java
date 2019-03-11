package com.qa.testPJ;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guangjiazheng on 2018/11/30.
 */
public class GetOrderList {

    final public static String URL = "http://120.27.13.239:8081/dmp/terminalNorthApi/device";
    final public static String Authorization = "a81abe568b0af8995901094810ff7ac1";

    public static  void testone() {

        JSONObject jsonObject = new JSONObject();
//        JSONObject jsonObject2 = new JSONObject();
//        jsonObject2.put("Content-Type",GetOrderList.Authorization);
//        jsonObject.put("date", jsonObject2);
//        jsonObject.put("Content-Type","application/json");
        jsonObject.put("deviceName", "哈哈哈");
        jsonObject.put("productId", "57700000152");
//        jsonObject2.put("pageSize",Integer.toString(10));
//        jsonObject.put("pageSize", "10");

        Map<String,Object> maplist = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
//        maplist.put("Authorization",GetOrderList.Authorization);
//        maplist.put("Form Data", jsonObject2);
//        maplist.put("pageNo", Integer.toString(1));
//        maplist.put("pageSize",Integer.toString(10));
//        maplist.put("pageSize", "10");

//        for (String key : maplist.keySet()) {
//            list.add(key);
//            //  System.out.println(key);
//        }
//        Collections.sort(list);
//        String listpara = GetOrderList.Authorization;
//        for (String tmp : list) {
//            listpara = listpara + tmp;
//            listpara = listpara + maplist.get(tmp);
//            //System.out.println(listpara);
//        }
//        String signstr = httpsend.SHA1(listpara).toLowerCase();
//        //System.out.println(signstr);
//        maplist.put("sign", signstr);
//
//        List params = new ArrayList();
//        for (String key : maplist.keySet()) {
//            params.add(new BasicNameValuePair(key, (String) maplist.get(key)));
//        }
//        JSONObject jsonObject = JSONObject.fromObject(restr);
//        int code = jsonObject.getInt("code");

        String restr = httpsend.doHttpPost(GetOrderList.URL,jsonObject);

        System.out.println(restr);
//        System.out.println(jsonObject2);
        System.out.println(jsonObject);

    }

    public static void main(String[] args){

        GetOrderList.testone();


    }


}
