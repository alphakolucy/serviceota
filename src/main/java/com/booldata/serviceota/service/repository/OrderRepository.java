package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.Order;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;

@Repository
public interface OrderRepository extends WiselyRepository<Order, String> {

}
