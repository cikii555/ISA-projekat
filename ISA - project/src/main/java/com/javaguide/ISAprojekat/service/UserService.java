package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.UserRegistrationDTO;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    private UserRepository userRepository;
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
    public void saveClient(UserRegistrationDTO userRegDTO) {
        Client client = new Client(userRegDTO);
        //userRepository.save(client);
    }
    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
        User user = new User(); //dok ne namestimo bazy
        return user;
    }
}
