package com.mxzx.sanmao.repository;

import com.mxzx.sanmao.dto.OrdersDetail;
import com.mxzx.sanmao.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("select new com.mxzx.sanmao.dto.OrdersDetail(id, supplier.name, customer.name) from Orders")
    List<OrdersDetail> listDto();
}
