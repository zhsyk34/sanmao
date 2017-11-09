package com.mxzx.sanmao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdersDetail {
    private long id;
    private String supplier;
    private String customer;
}
