package com.building.quizzapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.building.quizzapp.Question;
import com.building.quizzapp.dao.QuestionDao;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Question> getQuestionsByCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    


}
