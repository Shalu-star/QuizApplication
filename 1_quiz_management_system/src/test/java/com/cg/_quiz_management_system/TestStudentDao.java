package com.cg._quiz_management_system;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dao.StudentDao;
import com.cg.entities.Questions;
import com.cg.entities.Student;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudentDao {
@Autowired
private StudentDao dao;
@Test
public void studentTest() {
List<Student>studList=dao.showAllStudent();
assertEquals(5,studList.size());
}
@Test
public void searchstudentByid() {
Student s=dao.searchStudentById(3);
assertEquals(3,s.getStudId());
assertEquals("hari@cg.com",s.getStudEmail());
assertEquals(44,s.getStudMobNo());
assertEquals("hari",s.getStudName());
assertEquals("good",s.getStudPassword());


}
@Test
public void searchstudentByinvalidid() {
try {
Student s=dao.searchStudentById(768);
fail("Test failed");

}catch(Exception e) {
assertEquals("student not found",e.getMessage());
}


}
}


