package com.cg.dao.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.dao.SubjectDao;
import com.cg.entities.Student;
import com.cg.entities.Subject;
import com.cg.exception.SubjectNotFoundException;
import com.cg.repository.SubjectRepository;
@Component
public class SubjectDaoImpl implements SubjectDao{
	
	@PersistenceContext
	private EntityManager em;
    @Autowired
    private SubjectRepository subRepository;
	@Transactional
	public Subject deleteSubject(int subId) {
		Subject s = em.find(Subject.class, subId);
		subRepository.delete(s);
		return s;
	}
	@Transactional
	public Subject addSubject(Subject subject) {
		Subject s =subRepository.save(subject);
		return s;
	}
    @Transactional
	public List<Subject> showAllSubject() {
		String jpql="select s from Subject s";
		Query q=em.createQuery(jpql);
		List<Subject> subList=q.getResultList();
		return subList;
	}
	@Transactional
	public Subject searchSubjectById(int subId) {
		Subject sub=em.find(Subject.class , subId);
		while(sub != null)
		{
		if(sub.getSubId() == subId)
		{
		return sub;
		}
		}
		return null;
	}
	@Transactional
	public Subject findSubjectById(int subId) {
		Subject sub=em.find(Subject.class , subId);
		while(sub != null)
		{
		if(sub.getSubId() == subId)
		{
		return sub;
		}
		}
		throw new SubjectNotFoundException("subject not found");
	}

}
