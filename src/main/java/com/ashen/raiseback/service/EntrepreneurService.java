package com.ashen.raiseback.service;

import com.ashen.raiseback.model.Entrepreneur;
import com.ashen.raiseback.model.User;
import com.ashen.raiseback.repository.EntrepreneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntrepreneurService {
    private final EntrepreneurRepository entrepreneurRepository;

    @Autowired
    public EntrepreneurService( EntrepreneurRepository entrepreneurRepository){
        this.entrepreneurRepository = entrepreneurRepository;
    }

    public Entrepreneur createEntrepreneur ( Entrepreneur entrepreneur ){
        return this.entrepreneurRepository.save(entrepreneur);
    }

    public boolean deleteEntrepreneurByUser( User user ){
        Optional<Entrepreneur> entrepreneurOptional = entrepreneurRepository.findByUser(user);
        if (entrepreneurOptional.isPresent()) {
            Entrepreneur entrepreneur = entrepreneurOptional.get();
            entrepreneurRepository.delete(entrepreneur);
            return true;
        }
        return false;
    }

}