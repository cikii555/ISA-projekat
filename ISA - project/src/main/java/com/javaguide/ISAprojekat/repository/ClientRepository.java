package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
}
