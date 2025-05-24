package com.cg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Questions;
@Repository
public interface QuestionsRepository extends CrudRepository<Questions, Integer>{

}
