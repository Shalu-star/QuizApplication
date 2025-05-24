package com.cg.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dao.QuestionsDao;
import com.cg.entities.Questions;
@CrossOrigin(origins = "*",methods = RequestMethod.POST)
@RestController
@RequestMapping("/questions")
public class QuestionsCatalogue {
	@Autowired
	private QuestionsDao qsnDao;
	
	
	
	@PostMapping(consumes = {"application/json","application/xml"})
	public Questions addNewQuestions(@RequestBody Questions qsn){
		return qsnDao.addQuestion(qsn);
	}
	
	@RequestMapping(value ="/{qsnId}",produces = {"application/json","application/xml"})
	public Questions findQsnById(@PathVariable  int qsnId) {
		return qsnDao.searchQsnById(qsnId);
	}
	@GetMapping(produces={"application/json","application/xml"})
	public List<Questions> showAllQsn(){
		return qsnDao.showAllQuestions();
	}
	
	@PutMapping(value = "/{qsnId}", consumes = {"application/json","application/xml"})
	public Questions updateQuestion(@RequestBody Questions qsn,@PathVariable int qsnId){
		return qsnDao.updateQuestion(qsn,qsnId);
	}
	@DeleteMapping(value = "/{qsnId}")
	public Questions deleteQuestion(@PathVariable int qsnId){
		return qsnDao.deleteQuestion(qsnId);
	}

}
