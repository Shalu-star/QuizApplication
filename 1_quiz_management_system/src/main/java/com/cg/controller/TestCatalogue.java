package com.cg.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.StudentDao;
import com.cg.dao.TestDao;
import com.cg.dto.TestDTO;
import com.cg.entities.Test;
@RestController
@RequestMapping("/test")
public class TestCatalogue {
	@Autowired
	private StudentDao studDao;
	@Autowired
	private TestDao testDao;
	@PostMapping(consumes = {"application/json","application/xml"})
	public Test addNewTest(@RequestBody Test test){
		return testDao.addTest(test);
	}
	@GetMapping(produces={"application/json","application/xml"})
	public List<Test> showAllTest(){
		return testDao.showAllTest();
	}
	@RequestMapping(value ="/{testId}",produces = {"application/json","application/xml"})
	public Test findTestById(@PathVariable  int testId) {
		return testDao.searchTestById(testId);
	}
	@DeleteMapping(value = "/{testId}", consumes = {"application/json","application/xml"})
	public Test removeTest(@PathVariable int testId){
		return testDao.deleteTest(testId);
	}
	@PutMapping(value = "/{testId}", consumes = {"application/json","application/xml"})
	public Test updateTest(@RequestBody Test test,@PathVariable int testId){
		return testDao.updateTest(test,testId);
	}
	@PostMapping(value = "/appear",consumes = {"application/json","application/xml"})
	 public TestDTO appearTest(@RequestBody TestDTO dto){
          studDao.giveTest(dto);
          return dto;
	 }
	@GetMapping(value = "result/{testId}",produces={"application/json","application/xml"})
	public Test showResult(@PathVariable int testId) {
		return studDao.getResult(testId);
		//return ;
	}
}
