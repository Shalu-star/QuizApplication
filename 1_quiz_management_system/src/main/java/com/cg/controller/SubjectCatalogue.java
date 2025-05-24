package com.cg.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dao.SubjectDao;
import com.cg.entities.Subject;
@RestController
@RequestMapping("/subject")
public class SubjectCatalogue {
	@Autowired
	private SubjectDao subDao;
	
	@PostMapping(produces= {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public Subject addNewSubject(@RequestBody Subject sub){
		return subDao.addSubject(sub);
	}
	
	@GetMapping(produces={"application/json","application/xml"})
	public List<Subject> showAllSubject(){
		return subDao.showAllSubject();
	}
	
	@RequestMapping(value ="/{subId}",produces = {"application/json","application/xml"})
	public Subject findSubjectById(@PathVariable  int subId) {
		return subDao.searchSubjectById(subId);
	}

}
