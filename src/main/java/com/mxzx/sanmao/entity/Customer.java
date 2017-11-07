package com.mxzx.sanmao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//客户
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String no;//编号

    private String company;//公司
    private String name;//联系人

    private String address;//地址
    private String phone;//手机
}
