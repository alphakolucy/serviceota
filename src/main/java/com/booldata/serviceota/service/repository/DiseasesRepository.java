package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.Diseases;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;

@Repository
public interface DiseasesRepository extends WiselyRepository<Diseases, String> {

}
