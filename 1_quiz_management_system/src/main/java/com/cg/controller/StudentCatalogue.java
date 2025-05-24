package com.cg.controller;
import java.util.ArrayList;
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
import com.cg.dao.StudentDao;

import com.cg.entities.Student;
import com.cg.entities.Test;

import net.minidev.json.JSONObject;

@CrossOrigin(origins = "*",methods = RequestMethod.POST)
@RestController
@RequestMapping("/student")
public class StudentCatalogue {
	@Autowired
	private StudentDao studDao;
	
	@PostMapping(consumes = {"application/json","application/xml"})
	public Student addNewStudent(@RequestBody Student stu){
		return studDao.addStudent(stu);
	}
	@GetMapping(produces={"application/json","application/xml"})
	public List<Student> showAllStudent(){
		return studDao.showAllStudent();
	}
	@RequestMapping(value ="/{studId}",produces = {"application/json","application/xml"})
	public Student findStudentById(@PathVariable  int studId) {
		return studDao.searchStudentById(studId);
	}
	@PutMapping(value = "/{studId}", consumes = {"application/json","application/xml"})
	public Student updateStudentDetails(@RequestBody Student s,@PathVariable int studId){
		return studDao.updateProfile(s,studId);
	}
//	@RequestMapping(value ="/{studId}/quiz",produces = {"application/json","application/xml"})
//	public List<Integer> testGivenByStudent(@PathVariable  int studId) {
//		List<Integer> resList = new ArrayList<>();
//		Test t = studDao.giveTest(studId);
//		resList.add(t.getTestId());
//		return resList;
//		
//	}
	@DeleteMapping(value = "/{studId}", consumes = {"application/json","application/xml"})
	public Student deleteStudent(@PathVariable int studId){
		return studDao.deleteStudent(studId);
	}

}
