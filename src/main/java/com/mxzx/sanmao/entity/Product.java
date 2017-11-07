package com.mxzx.sanmao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//产品
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String no;//编号
    private String name;//名称

    private String unit;//单位
    private int price;//单价
}
