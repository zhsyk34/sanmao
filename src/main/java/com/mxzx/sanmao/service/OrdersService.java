package com.mxzx.sanmao.service;

import com.mxzx.sanmao.entity.Detail;
import com.mxzx.sanmao.entity.Orders;
import com.mxzx.sanmao.repository.DetailRepository;
import com.mxzx.sanmao.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final DetailRepository detailRepository;

    public Long save(Orders orders, List<Detail> details) {
        int total = details.stream().mapToInt(Detail::getMoney).sum();
        logger.debug("orders detail price sum => total:{}", total);
        orders.setTotal(total);

        Orders created = ordersRepository.save(orders);

        details.forEach(detail -> {
            detail.setOrders(created);
            detailRepository.save(detail);
        });

        return created.getId();
    }
}
