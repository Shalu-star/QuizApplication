package com.cg.dao;
import java.util.List;

import com.cg.dto.TestDTO;
import com.cg.entities.Student;
import com.cg.entities.Test;


public interface StudentDao {
	Test giveTest(TestDTO dto);
	Test getResult(int testId);
	Student updateProfile(Student student,int studId);
	Student addStudent(Student student);
	Student deleteStudent(int studId);
	List<Student> showAllStudent();
	Student searchStudentById(int studId);

}
