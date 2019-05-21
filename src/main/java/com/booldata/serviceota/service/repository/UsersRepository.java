package com.booldata.serviceota.service.repository;

import org.springframework.stereotype.Repository;

import com.booldata.serviceota.model.Users;
import com.booldata.serviceota.service.repository.wisely.WiselyRepository;

@Repository
public interface UsersRepository extends WiselyRepository<Users, String> {

}
