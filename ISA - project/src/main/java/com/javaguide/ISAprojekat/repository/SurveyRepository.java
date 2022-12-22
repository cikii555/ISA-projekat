package com.javaguide.ISAprojekat.repository;

import com.javaguide.ISAprojekat.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
