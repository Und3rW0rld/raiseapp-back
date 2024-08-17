package com.ashen.raiseback.service;

import com.ashen.raiseback.model.User;
import com.ashen.raiseback.model.UserType;
import com.ashen.raiseback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final EntrepreneurService entrepreneurService;

    private final InvestorService investorService;

    @Autowired
    public UserService( UserRepository userRepository, EntrepreneurService entrepreneurService, InvestorService investorService ) {
        this.userRepository = userRepository;
        this.entrepreneurService = entrepreneurService;
        this.investorService = investorService;
    }

    public User createUser ( User user ){
        return userRepository.save( user );
    }

    public Optional<User> getUserById ( long id ){
        return userRepository.findById( id );
    }

    public User existsByEmail( String email ){
        return userRepository.getUserByEmail(email);
    }

    public boolean deleteUserById(Long id) {
        // Retrieve the user
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Delete associated Entrepreneur or Investor entity if applicable
            if (user.getType() == UserType.ENTREPRENEUR) {
                entrepreneurService.deleteEntrepreneurByUser(user);
            } else if (user.getType() == UserType.INVESTOR) {
                investorService.deleteInvestorByUser(user);
            }

            // Delete the user
            userRepository.delete(user);
            return true;
        }
        return false; // User not found
    }

}
