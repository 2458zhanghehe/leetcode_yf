package com.company.Shousi.proxy.jdk;

import java.io.IOException;

public class TestProxyJdk {

    public static void main(String[] args) throws IOException {
        BigStarJdk bigStarJdk = new BigStarJdk("kun");
        Star proxy = ProxyUtilJdk.createProxy(bigStarJdk);
        proxy.sing("姬霓太美");

        //arthas 调试使用
//        System.out.println(proxy.getClass());
//        System.in.read();

        System.out.println("==========================");
        String result = proxy.dance();
        System.out.println(result);
    }
}
