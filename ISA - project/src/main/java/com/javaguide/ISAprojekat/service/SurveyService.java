package com.javaguide.ISAprojekat.service;

import com.javaguide.ISAprojekat.model.Client;
import com.javaguide.ISAprojekat.model.Survey;
import com.javaguide.ISAprojekat.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    public void saveSurvey(Survey survey){
        surveyRepository.save(survey);
    }

    public Boolean canDonate(Client client) {
        List<Survey> all = surveyRepository.findAll();
        for(Survey s:all){
            if(s.getClient().getId().equals(client.getId()))
                return true;
        }
        return false;
    }
}
