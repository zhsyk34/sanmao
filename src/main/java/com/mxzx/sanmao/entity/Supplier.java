package com.mxzx.sanmao.entity;

import lombok.Data;

import javax.persistence.*;

//供应商
@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;
}
