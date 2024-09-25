package com.company.Shousi.GoF23.proxy.cgLib;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class TestProxyCglib {
    public static void main(String[] args) {
        BigStarCglib starCglib = new BigStarCglib("ikun");
        ProxyUtilCglib proxyUtilCglib = new ProxyUtilCglib();
        BigStarCglib proxy = proxyUtilCglib.createProxyIns(starCglib);
        proxy.sing("及你太美");
        String end = proxy.dance();
        log.debug("{}",end);

        log.debug("prxoy类型,{}",proxy.getClass());

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
