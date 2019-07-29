package com.qa.Case;

import java.math.BigInteger;

/**
 * Created by guangjiazheng on 2019/3/11.
 */
public class test {
    public static void main(String[] args){
        String a = "123";
        String b = "321";

        String c = new BigInteger(a).add(new BigInteger(b)).toString();
        System.out.println(c);

    }
}
