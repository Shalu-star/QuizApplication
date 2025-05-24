package com.cg.dao.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.dao.TestDao;
import com.cg.entities.Student;
import com.cg.entities.Subject;
import com.cg.entities.Test;
import com.cg.exception.TestNotFoundException;
import com.cg.repository.TestRepository;
@Component
public class TestDaoImpl implements TestDao{
	@PersistenceContext
	private EntityManager em;
    @Autowired
    private TestRepository testRepository;
    
	@Transactional
	public Test addTest(Test test) {
		Subject s = em.find(Subject.class,101);
		Student st = em.find(Student.class,1001);
		//Questions qs = em.
		if(s != null) 
		{
			test.setSubject(s);
			test.setStudent(st);
			Test t =testRepository.save(test);
			return t;
		}
		return null;
	}
	@Transactional
	public Test updateTest(Test t, int tId) {
		Test t1=em.find(Test.class, tId);
		if(t1!=null) {
			t1.setTestId(t.getTestId());;
			t1.setMarks(t.getMarks());
			t1.setSubject(t.getSubject());
			
			}
		return t1;	
	}
    @Transactional
	public Test deleteTest(int tId) {
		Test t1 = em.find(Test.class, tId);
		testRepository.delete(t1);
		
		return null;
	}
	@Transactional
	public List<Test> showAllTest() {
		String jpql="select t from Test t";
		Query q=em.createQuery(jpql);
		List<Test> testList=q.getResultList();
		return testList;
	}
	@Transactional
	public Test searchTestById(int id)
	{
	Test t1=em.find(Test.class , id);
	while(t1 != null)
	{
	if(t1.getTestId() == id)
	{
	return t1;
	}
	}
	throw new TestNotFoundException("test not found");

	}
	
}
