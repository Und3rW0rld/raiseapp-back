package com.ashen.raiseback.service;

import com.ashen.raiseback.model.Business;
import com.ashen.raiseback.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Business> getAllBusiness(){
        return this.businessRepository.findAll();
    }

    public Optional<Business> getBusinessById( long id ){
        return this.businessRepository.findById( id );
    }

    public List<Business> getBusinessByEntrepreneurId( long id ){
        return this.businessRepository.findByEntrepreneur_Id( id );
    }

}
