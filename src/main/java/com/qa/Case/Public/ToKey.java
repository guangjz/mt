package com.qa.Case.Public;

import net.sf.json.JSONObject;

/**
 * Created by guangjiazheng on 2019/3/12.
 */
public class ToKey {

    public static JSONObject MJ01001 (String content){

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("appId", "A2016120614401100003");
        jsonParam.put("timestamp", "20180810150007");
        jsonParam.put("messageId", "b61a16e7e6b54ff2a5e24b9658595cca");
        jsonParam.put("sessionId","506acd3faa054da1ad9d91d9e098f989");
        jsonParam.put("content",content);
        return jsonParam;
    }

    public static JSONObject MJ01002 (String content){

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("appId", "A2016120614401100003");
        jsonParam.put("timestamp", "20180810150007");
        jsonParam.put("messageId", "b61a16e7e6b54ff2a5e24b9658595cca");
        jsonParam.put("sessionId","506acd3faa054da1ad9d91d9e098f989");
        jsonParam.put("content",content);
        return jsonParam;
    }

    public static JSONObject MJ01003 (String content){

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("messageId", "08706528c87c471683ddcf25aa607703");
        jsonParam.put("sessionId","08706528c87c471683ddcf25aa607703");
        jsonParam.put("timestamp", "20180904173742");
        jsonParam.put("appId", "A2016120614401100003");
        jsonParam.put("content",content);
        return jsonParam;
    }

    public static JSONObject MJ01004 (String content,String header){

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("messageId", "08706528c87c471683ddcf25aa607703");
        jsonParam.put("sessionId","08706528c87c471683ddcf25aa607703");
        jsonParam.put("timestamp", "20180904173742");
        jsonParam.put("content",content);
        jsonParam.put("appId", "A2018073116192600003");
        jsonParam.put("header",header);
        return jsonParam;
    }

}
