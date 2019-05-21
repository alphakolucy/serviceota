package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.TArea;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;

@Repository 
public interface TAreaRepository extends WiselyRepository<TArea, String>  {

}
