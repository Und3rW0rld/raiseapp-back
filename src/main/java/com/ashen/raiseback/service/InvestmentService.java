package com.ashen.raiseback.service;

import com.ashen.raiseback.model.Investment;
import com.ashen.raiseback.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {
    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService( InvestmentRepository investmentRepository ){
        this.investmentRepository = investmentRepository;
    }

    public Investment createInvestment( Investment investment ){
        return this.investmentRepository.save(investment);
    }

}
