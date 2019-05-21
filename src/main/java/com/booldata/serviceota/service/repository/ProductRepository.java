package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.Product;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;

@Repository
public interface ProductRepository extends WiselyRepository<Product, String> {

}
