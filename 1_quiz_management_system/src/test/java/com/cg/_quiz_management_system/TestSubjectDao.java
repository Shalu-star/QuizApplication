package com.cg._quiz_management_system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dao.SubjectDao;
import com.cg.entities.Subject;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSubjectDao {
@Autowired
private SubjectDao dao;
@Test
public void subjectTest() {
List<Subject>subList=dao.showAllSubject();
assertEquals(4,subList.size());
}
@Test
public void searchsubjectByid() {
Subject s=dao.searchSubjectById(101);
assertEquals(101,s.getSubId());
assertEquals("Java",s.getSubName());
}
@Test
public void searchsubjectByinvalidid() {
try {
Subject s=dao.searchSubjectById(76890);
fail("Test failed");

}catch(Exception e) {
assertEquals("subject not found",e.getMessage());
}

}

}

