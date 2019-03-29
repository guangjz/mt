package com.qa.Case.EC_Console;

import org.apache.http.client.methods.HttpPost;

/**
 * Created by guangjiazheng on 2019/3/29.
 */
public class getUserMenuList {

    public static final String url = "http://112.35.22.232:8025/ec-console/sys/menu/getUserMenuList";

    public static void getUserMenuList_qa(){
        HttpPost post = new HttpPost();
        post.addHeader("token","28039407f66e9bcdd0b6782a0ea1b7b5");

    }
}
