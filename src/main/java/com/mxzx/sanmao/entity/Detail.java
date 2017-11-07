package com.mxzx.sanmao.entity;

import lombok.Data;

import javax.persistence.*;

//订单明细
@Entity
@Data
public class Detail {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Orders orders;//所属订单

    @ManyToOne
    private Product product;//产品

    private String name;//项目
    private String content;//内容

    private int width;
    private int height;

    private int money;//金额

    private String remarks;//备注
}
