package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.SmartDietitian;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;

@Repository
public interface SmartDietitianRepository extends WiselyRepository<SmartDietitian, String>  {

}
