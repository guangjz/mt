package com.qa.testPJ;

/**
 * Created by guangjiazheng on 2018/11/30.
 */
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import sohuadx.WriteLog;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class httpsend {

    final public static String  filePath4=".//src//responsetime.txt";


    public static String doHttpPost(String url, Map<String, Object> paras){
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String jsonResult = null;
        long starttime = 0;
        long endtime = 0;
        HttpPost method = new HttpPost(url);
//        method.addHeader("Content-Type", "application/json;charset=utf-8");
        try {
//            method.setEntity(new UrlEncodedFormEntity((List<? extends NameValuePair>) paras,HTTP.UTF_8));
            starttime = System.currentTimeMillis();
            HttpResponse result = httpClient.execute(method);
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                endtime = System.currentTimeMillis();
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());

                    /**把json字符串转换成json对象**/
                    jsonResult = str;
                    //System.out.println(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long timedifer = endtime - starttime;

        WriteLog.writeIntoFile("Response响应时间：  " + timedifer + "毫秒", httpsend.filePath4, true);
        return jsonResult;


    }


    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("content-type", "application/json;charset=utf-8");
            connection.setRequestProperty("cookie", "_lxsdk=15a45e79874c8-0dbaa72b4d347d-1d356f53-fa000-15a45e79874c8; __mta=214144936.1484205542049.1487571700485.1487571710121.22; _ga=GA1.2.1431074261.1487659506; TGC=838bedcaaf8343a0b8bd*c2c0c5744b9; ssoid=838bedcaaf8343a0b8bd*c2c0c5744b9; JSESSIONID=; skmtutc=/w4XooEHuIJYLBnlBTs/QoaaTHVrolAepvZnk1dGIu6JJ5IOO5MAj2In7pyxeCma-p7YmTaLx5prZdidL/nRkV6zfOIE=; _lxsdk_s=6cab733f4799711e782a18450965%7C%7C56; __mta=214144936.1484205542049.1487571710121.1490322515820.23");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }



    public static Map<String,String> rereadTxtFile(String filePath) {

        String lineTxt = null;
        Map<String, String> map = new HashMap<String, String>();
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    //System.out.println(lineTxt);
                    map.put(lineTxt.split("\\=")[0], lineTxt.split("\\=")[1]);

                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            // e.printStackTrace();
        }
        return map;
    }
    public static String secret(Map<String,String> map,String secret){
        List<String> list=new ArrayList<String>();
        for (String key : map.keySet()) {
            list.add(key);
        }
        Collections.sort(list);
        String listpara=secret;
        for(String tmp:list)
        {
            listpara=listpara+tmp;
            listpara=listpara+map.get(tmp);
        }
        String signstr= httpsend.SHA1(listpara).toLowerCase();
        return signstr;
    }

    public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws Exception{
        String s = sendGet("http://page.banma.test.sankuai.com/api/admin/grade/franchiseeResult/downloadFranchiseeOrderInfo", "orgId=49&timeStr=2017-02&primary=491490322523431");
        System.out.println(s);

    }


}