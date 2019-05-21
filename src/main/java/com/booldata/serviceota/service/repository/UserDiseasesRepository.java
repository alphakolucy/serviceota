package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.UserDiseases;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;

@Repository
public interface UserDiseasesRepository extends WiselyRepository<UserDiseases, String> {

}
