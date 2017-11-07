package com.mxzx.sanmao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Supplier supplier;//供应商

    @ManyToOne
    private Customer customer;//客户

    private int total;//总额
    private int reduce;//优惠

    private int paid;//已付
    private String recorder;//开单员
}
