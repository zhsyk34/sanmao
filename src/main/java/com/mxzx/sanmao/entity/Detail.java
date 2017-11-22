package com.mxzx.sanmao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

//订单明细
@Entity
@Data
@ToString(exclude = "orders")
@EqualsAndHashCode(exclude = "orders")
public class Detail {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Orders orders;//所属订单

    @ManyToOne
    private Product product;//产品

    @Column(nullable = false)
    private String name;//项目

    @Column(nullable = false)
    private String content;//内容

    private int width;
    private int height;

    private int count;//数量

    private int money;//金额

    private String remarks;//备注
}
