package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.dto.UserRegistrationDTO;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;
import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.model.MedicalStaff;
import com.javaguide.ISAprojekat.repository.ClientRepository;
import com.javaguide.ISAprojekat.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;

    public UserService(ClientRepository clientRepository, RoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
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
    public Client save(Client client) {
        return clientRepository.save(client);
    }
    public void updateClient(Client client) {
        clientRepository.save(client);
    }
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public Client findOne(Integer id) {
        return clientRepository.findById(id).orElseGet(null);

    }
}
