package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.SubsidyApply;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;

@Repository
public interface SubsidyApplyRepository extends WiselyRepository<SubsidyApply, String>  {

}
