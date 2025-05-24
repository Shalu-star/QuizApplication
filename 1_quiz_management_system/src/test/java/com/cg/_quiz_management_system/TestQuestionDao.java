package com.cg._quiz_management_system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dao.QuestionsDao;
import com.cg.entities.Questions;


@RunWith(SpringRunner.class)
@SpringBootTest


public class TestQuestionDao {
	
  @Autowired
  private QuestionsDao dao;
  @Test
  public void questionTest() {
   List<Questions>qnsList=dao.showAllQuestions();
   assertEquals(2,qnsList.size());
  }
  @Test
  public void searchQuestionById() {
   Questions q=dao.searchQsnById(2000);
   assertEquals(2000,q.getQsnId());
   assertEquals("option3",q.getCorOption());
   assertEquals("6",q.getOption1());
   assertEquals("7",q.getOption2());
   assertEquals("8",q.getOption3());
   assertEquals("9",q.getOption4());
   assertEquals("Number of primitive data types in Java are?",q.getQsn());
   
  }
  @Test
  public void searchQuestionByInvalidId() {
   try {
    Questions q=dao.searchQsnById(7689);
    fail("Test failed");
    
   }catch(Exception e) {
    assertEquals(" question not found",e.getMessage());
   }
   
  }
  

}

