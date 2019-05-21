package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.Company;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;
 

@Repository
public interface CompanyRepository extends WiselyRepository<Company, String> {




}
