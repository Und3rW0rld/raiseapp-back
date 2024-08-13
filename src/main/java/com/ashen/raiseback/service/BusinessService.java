package com.ashen.raiseback.service;

import com.ashen.raiseback.model.Business;
import com.ashen.raiseback.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Business createBusiness( Business business ) {
        return this.businessRepository.save(business);
    }

}
