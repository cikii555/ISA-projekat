package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findByFirstName(String firstName);
    //User findByUserId(Long userId);
    List<User> findByLastName(String lastName);
}
