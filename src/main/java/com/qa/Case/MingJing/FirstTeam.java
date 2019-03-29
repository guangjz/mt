package com.qa.Case.MingJing;

import com.qa.Case.Public.HostAddress;
import com.qa.Case.Public.HttpPost;
import com.qa.Case.Public.ToKey;
import com.qa.jdbc.DateUtil;
import net.sf.json.JSONObject;
import org.testng.annotations.Test;

/**
 * Created by guangjiazheng on 2019/3/7.
 */
public class FirstTeam {

    public static final String url = "/openapi/V1/partner/ability/production/FirstTeam";

    @Test
    public static void FirstTeam_qa() throws Exception {

        int nowtime_int = (int) (System.currentTimeMillis()/1000);
        String nowtime_datetime = DateUtil.timeStamp2Date(String.valueOf(nowtime_int),"yyyyMMddhhmmss");
        int requestNo = (int)((Math.random()*9+1)*10000);

        JSONObject pub1 = new JSONObject();
        pub1.put("origSource","ZQKF");
        pub1.put("homeSource","ZQMJ");
        pub1.put("requestNo",nowtime_datetime+requestNo);
        pub1.put("requestNoTime",nowtime_datetime);
        pub1.put("bIPCode","MJ01001");

        JSONObject pub = new JSONObject();
        pub.put("pub",pub1.toString());

        JSONObject inputPara = new JSONObject();
        inputPara.put("bIPCode","MirrorFirstTeamReq");

        JSONObject fja = ToKey.MJ01001(pub.toString());

        System.out.println(fja);

        HttpPost.topost(HostAddress.test_qa_url+FirstTeam.url,fja.toString());

    }

}
