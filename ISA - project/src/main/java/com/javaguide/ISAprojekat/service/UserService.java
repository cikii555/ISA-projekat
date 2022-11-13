package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.UserRegistrationDTO;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.model.Role;
import com.javaguide.ISAprojekat.model.User;
import com.javaguide.ISAprojekat.repository.ClientRepository;
import com.javaguide.ISAprojekat.repository.RoleRepository;
import com.javaguide.ISAprojekat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;


    public UserService(ClientRepository clientRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    //    private UserRepository userRepository;
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
    public void saveClient(UserRegistrationDTO userRegDTO) {
        Client client = new Client(userRegDTO);
        client.setRole(roleRepository.findByName("ROLE_CLIENT"));
        clientRepository.save(client);
    }
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }


    public List<User> findUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
    public List<User> findUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public User insertSystemAdmin(User user){
        Role role = new Role("SYSTEMADMIN");
        user.setRole(role);

        return userRepository.save(user);
    }
    public User insertCenterAdmin(User user){
        Role role = new Role("CENTERADMIN");
        user.setRole(role);

        return userRepository.save(user);
    }
}
