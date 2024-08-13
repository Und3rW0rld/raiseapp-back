package com.ashen.raiseback.service;

import com.ashen.raiseback.model.Investor;
import com.ashen.raiseback.model.User;
import com.ashen.raiseback.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvestorService {
    private final InvestorRepository investorRepository;

    @Autowired
    public InvestorService( InvestorRepository investorRepository ){
        this.investorRepository = investorRepository;
    }

    public Investor createInvestor (Investor investor){
        return this.investorRepository.save(investor);
    }

    public boolean deleteInvestorByUser( User user ){
        Optional<Investor> investorOptional = investorRepository.findByUser(user);
        if (investorOptional.isPresent()) {
            Investor investor = investorOptional.get();
            investorRepository.delete(investor);
            return true;
        }
        return false;
    }
}
