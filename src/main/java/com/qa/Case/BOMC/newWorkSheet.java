package com.qa.Case.BOMC;

import com.qa.Case.BOMC.Public.Parameter;
import com.qa.Case.Public.HostAddress;
import com.qa.Case.Public.StaxonUtils;
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

        object.put("serialNo","20190402ZQKF0221585");

        String attachRef = StaxonUtils.json2xml(Parameter.attachRef().toString());
        object.put("attachRef",attachRef);
        System.out.println(attachRef);

        String opDetail = StaxonUtils.json2xml(Parameter.opDetail().toString());
        object.put("opDetail",opDetail);
        System.out.println(opDetail);
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
