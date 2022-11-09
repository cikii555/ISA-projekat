package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    //User findByUserId(Long userId);
}
