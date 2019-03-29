package com.qa.Case.ESOP;

import net.sf.json.JSONObject;

/**
 * Created by guangjiazheng on 2019/3/13.
 */
public class ESOP_AUTH_002 {

    public static JSONObject MJ01001 (String content){

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("appId", "A2016120614401100003");
        jsonParam.put("timestamp", "20180810150007");
        jsonParam.put("messageId", "b61a16e7e6b54ff2a5e24b9658595cca");
        jsonParam.put("sessionId","506acd3faa054da1ad9d91d9e098f989");
        jsonParam.put("content",content);
        return jsonParam;
    }
}
