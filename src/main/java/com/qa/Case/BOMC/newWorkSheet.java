package com.qa.Case.BOMC;

import com.qa.Case.Public.HostAddress;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by guangjiazheng on 2019/5/29.
 */
public class newWorkSheet {

    public static final java.lang.String url = "/geec-order/api/v1/bomc/call/newWorkSheet";

    @Test
    public void newWorkSheet_qa() throws UnsupportedEncodingException, JSONException {
        // 创建默认的httpClient实例.
        HttpClient httpClient = HttpClientBuilder.create().build();
        // 创建httppost
        HttpPost httpPost = new HttpPost(HostAddress.QA_geecorder_ip+newWorkSheet.url);
        httpPost.addHeader("token",HostAddress.QA_geecorder_token);

        // NameValuePair[] info={new NameValuePair("str","str33434")};
//        Gson gson = new Gson();
        //toJson方法参数即一个javabean。返回值即一个json字符串
//        String json = gson.toJson(new G("A0001"));
        JSONObject object = new JSONObject();

        object.put("serialNo","66004");
        object.put("opPerson","广家政");
        object.put("opTime","2019-06-17 14:58:01");
        object.put("sheetType","101");
        object.put("callTime","2019-06-17 14:58:01");
        object.put("serSupplier","JT_BOMC");
        object.put("serCaller","JT_BBOSS");
        object.put("serviceType","999");
        object.put("opCorp","亚信科技");
        object.put("callerPwd","");
        object.put("opContact","15694116666");
        object.put("opDepart","BOMC");


//        String attachRef = StaxonUtils.json2xml(Parameter.attachRef().toString());
        object.put("attachRef", "<attachRef></attachRef>");

//        System.out.println(attachRef);

//        String opDetail = StaxonUtils.json2xml(Parameter.opDetail().toString());
        object.put("opDetail","<opDetail><fieldInfo><fieldChName>工单来源</fieldChName><fieldEnName>origin</fieldEnName><fieldContent>山东院</fieldContent></fieldInfo><fieldInfo><fieldChName>工单类型</fieldChName><fieldEnName>type</fieldEnName><fieldContent>查询报文信息</fieldContent></fieldInfo><fieldInfo><fieldChName>登记人</fieldChName><fieldEnName>register</fieldEnName><fieldContent>系统管理员</fieldContent></fieldInfo><fieldInfo><fieldChName>登记时间</fieldChName><fieldEnName>regtime</fieldEnName><fieldContent>2019-06-17 10:56:28</fieldContent></fieldInfo><fieldInfo><fieldChName>所属业务</fieldChName><fieldEnName>business</fieldEnName><fieldContent>PushEmail</fieldContent></fieldInfo><fieldInfo><fieldChName>期望解决时间</fieldChName><fieldEnName>hopetime</fieldEnName><fieldContent>2019-06-17 10:56:32</fieldContent></fieldInfo><fieldInfo><fieldChName>最晚回复时间</fieldChName><fieldEnName>limitedtime</fieldEnName><fieldContent>2019-06-22 10:56:34</fieldContent></fieldInfo><fieldInfo><fieldChName>工单标题</fieldChName><fieldEnName>title</fieldEnName><fieldContent>阿广的测试数据</fieldContent></fieldInfo><fieldInfo><fieldChName>描述</fieldChName><fieldEnName>desc</fieldEnName><fieldContent>123</fieldContent></fieldInfo><fieldInfo><fieldChName>登记人联系电话</fieldChName><fieldEnName>phonenumber</fieldEnName><fieldContent>15694119662</fieldContent></fieldInfo><fieldInfo><fieldChName>客户信息</fieldChName><fieldEnName>customer_info</fieldEnName><fieldContent>亚新科技（中国）有限公司</fieldContent></fieldInfo><fieldInfo><fieldChName>关键信息</fieldChName><fieldEnName>key_info</fieldEnName><fieldContent>123</fieldContent></fieldInfo><fieldInfo><fieldChName>是否省公司处理</fieldChName><fieldEnName>ispProvice</fieldEnName><fieldContent></fieldContent></fieldInfo><fieldInfo><fieldChName>审批人</fieldChName><fieldEnName>appover</fieldEnName><fieldContent></fieldContent></fieldInfo><fieldInfo><fieldChName>审批意见</fieldChName><fieldEnName>appover_opinion</fieldEnName><fieldContent></fieldContent></fieldInfo><fieldInfo><fieldChName>BOMC侧工单ID</fieldChName><fieldEnName>taskoid</fieldEnName><fieldContent>618001</fieldContent></fieldInfo></opDetail>");

//        object.put("opDetail",opDetail);
//        System.out.println(opDetail);
        System.out.println(object);
        StringEntity body = new StringEntity(object.toString(1));
        // 创建参数队列
//        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//    formparams.add(new BasicNameValuePair("lockNo", json));
        // formparams.add(new BasicNameValuePair("transitDepotNo", "45646"));

        try {
            //RequestEntity entity = new StringRequestEntity(requestStr,"application/json","UTF-8");
//       UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httpPost.setEntity(body);
            httpPost.addHeader("encoding", "UTF-8");
            httpPost.addHeader("content-type", "application/json; charset=utf-8");
            System.out.println("executing request " + httpPost.getURI());
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());

            try {
                HttpEntity entity1 = response.getEntity();

                if (entity1 != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entity1, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } finally {
                httpPost.releaseConnection();
//            response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
//        try {
////            httpClient.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        }
    }
}
