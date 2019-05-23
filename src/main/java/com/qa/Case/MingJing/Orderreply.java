package com.qa.Case.MingJing;

import com.qa.Case.Public.HttpPost;
import com.qa.Case.Public.ToKey;
import com.qa.jdbc.DateUtil;
import net.sf.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by guangjiazheng on 2019/5/16.
 */
public class Orderreply {

    public static final String url = "http://112.35.22.232:8011/geec-order/mirrorservice/orderreply";

    @Test
    public static void orderreply_qa() throws Exception {

        int nowtime_int = (int) (System.currentTimeMillis() / 1000);
        String nowtime_datetime = DateUtil.timeStamp2Date(String.valueOf(nowtime_int), "yyyy-MM-dd hh:mm:ss");
        int requestNo = (int) ((Math.random() * 9 + 1) * 10000);

        String nowtime_datetime2 = DateUtil.timeStamp2Date(String.valueOf(nowtime_int), "yyyyMMddhhmmss");


        JSONObject pub1 = new JSONObject();
        pub1.put("bIPCode", "MJ01004");
        pub1.put("origSource", "ZQMJ");
        pub1.put("homeSource", "ZQKF");
        pub1.put("requestNo", nowtime_datetime2 + requestNo);
        pub1.put("requestNoTime", nowtime_datetime2);
        JSONObject inputPara = new JSONObject();
//        inputPara.put("extFormCode","20180904ZQKF010001");
        inputPara.put("extFormCode", "20190516ZQKF010007");
        inputPara.put("formCode", "IT-Complain-201809-0011");
        inputPara.put("handler", "lenson");
        inputPara.put("handlerTel", "13810571872");
        inputPara.put("handlerFullName", "李天明");
        inputPara.put("assignee", "lanxuexing");
        inputPara.put("doneTime", nowtime_datetime);
        inputPara.put("rsltDesc", "已解决");
        inputPara.put("dealOpinion", "1111");

//        inputPara.put("attachments", "[{\"attachID\":\"95001\",\"attachName\":\"编码\",\"attachType\":\"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;xlsx\",\"attachUrl\":\"http://112.35.3.9:8081/Attachment?attachID=95001\"}]");
        ArrayList fg = new ArrayList();

        JSONObject attachments = new JSONObject();
        attachments.put("attachID", "95001");
        attachments.put("attachName", "编码");
        attachments.put("attachType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;xlsx");
        attachments.put("attachUrl", "https://dl.google.com/chrome/mac/stable/GGRO/googlechrome.dmg\n");
        fg.add(0,attachments);
        inputPara.put("attachments",fg.toString());

        JSONObject content = new JSONObject();
        content.put("inputPara", inputPara.toString());

        JSONObject pub = new JSONObject();
        content.put("pub", pub1.toString());
        pub.put("pub", pub1.toString());


        JSONObject header = new JSONObject();
        header.put("tradeStaffId", "13");
        header.put("tradeDepartId", "134");
        header.put("tradeCityCode", "13");
        header.put("tradeEparchyCode", "13");


        JSONObject fja = ToKey.MJ01004(content.toString(), header.toString());

        System.out.println(fja);

        HttpPost.topost(Orderreply.url, fja.toString());

    }

}
