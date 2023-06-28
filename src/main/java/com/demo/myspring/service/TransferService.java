package com.demo.myspring.service;

public interface TransferService {
    public void test();

    public void transfer(String fromid, String toid, int money) throws Exception;
}
