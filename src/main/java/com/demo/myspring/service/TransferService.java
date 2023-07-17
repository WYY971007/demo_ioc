package com.demo.myspring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {
    public void test();

    public void transfer(String fromid, String toid, int money) throws Exception;
}
