package com.demo.myspring.utils.stock.entity;

import lombok.Data;

@Data
public class Stock {

    private String code;
    private String name;
    private String market;
    private String pinyin;
    private String category;

}
