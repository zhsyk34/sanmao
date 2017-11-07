package com.mxzx.sanmao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//供应商
@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String phone;
}
