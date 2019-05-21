package com.booldata.serviceota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booldata.serviceota.model.Company;
import com.booldata.serviceota.service.repository.CompanyRepository; 
 

@RestController
@RequestMapping("/company") 
public class CompanyController {
	
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<Company>> findAll(Company entity,
                                                  String housingEstateId,
                                                  String policeStationId,
                                                  String policeAreaId,
                                                  @PageableDefault(value = 10, sort = {"id"}, direction = Sort.Direction.DESC)
                                                          Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                //模糊方式查 
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()) ;
        

        Example<Company> example = Example.of(entity, matcher);
        Page<Company> company = this.companyRepository.findAll(example, pageable);
        return new ResponseEntity<Page<Company>>(company, HttpStatus.OK);
    }
}
