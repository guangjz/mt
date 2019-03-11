package com.qa.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by guangjiazheng on 2018/12/14.
 */
public class http_get {

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
}
