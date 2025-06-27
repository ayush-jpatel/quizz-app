package com.building.quizzapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.building.quizzapp.dao.QuestionDao;
import com.building.quizzapp.dao.QuizDao;
import com.building.quizzapp.model.Question;
import com.building.quizzapp.model.QuestionWrapper;
import com.building.quizzapp.model.Quiz;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsToUser = new ArrayList<>();

        for( Question q : questionsFromDB){
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsToUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionsToUser, HttpStatus.OK);
    }
}