package com.building.quizzapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.building.quizzapp.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
