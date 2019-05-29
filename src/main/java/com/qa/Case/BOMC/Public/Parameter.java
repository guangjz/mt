package com.qa.Case.BOMC.Public;

import net.sf.json.JSONObject;
import org.testng.annotations.Test;

/**
 * Created by guangjiazheng on 2019/5/29.
 */
public class Parameter {

    public static JSONObject opDetail (){

        JSONObject opDetail = new JSONObject();
        JSONObject fieldInfo = new JSONObject();

        fieldInfo.put("fieldChName","");
        fieldInfo.put("fieldEnName","");
        fieldInfo.put("fieldContent","");

        opDetail.put("fieldInfo",fieldInfo.toString());

        JSONObject details = new JSONObject();
        details.put("opDetail",opDetail);
//        System.out.println(details);
        return details;
    }

    @Test
    public static JSONObject attachRef () {


        JSONObject attachInfo = new JSONObject();
        attachInfo.put("attachName","");
        attachInfo.put("attachURL","");
        attachInfo.put("attachLength","");
        JSONObject attachRef = new JSONObject();
        attachRef.put("attachInfo",attachInfo.toString());
        JSONObject Enclosure = new JSONObject();
        Enclosure.put("attachRef",attachRef);
//        System.out.println(Enclosure);
        return Enclosure;

    }
}
