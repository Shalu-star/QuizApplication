package com.cg.dao.impl;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.dao.QuestionsDao;
import com.cg.entities.Questions;
import com.cg.entities.Subject;
import com.cg.exception.QuestionsNotFoundException;
import com.cg.repository.QuestionsRepository;
@Component
public class QuestionsDaoImpl implements QuestionsDao{
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private QuestionsRepository qsnRepository;
	
    @Transactional
	public Questions addQuestion(Questions qsn) {
    	Subject s = em.find(Subject.class, 102);
    	//Test t = em.find(Test.class, 201);
    	if(s!=null) {
    		qsn.setSubject(s);
    		//t.setQsnList(qsn);
    		Questions questions = qsnRepository.save(qsn);
   			return questions;
    	}
	    return null;
	}
	
    @Transactional
	public Questions updateQuestion(Questions qsn, int qsnId) {
		Questions q1=em.find(Questions.class, qsnId);
		if(q1!=null) {
			q1.setQsnId(qsn.getQsnId());
			q1.setQsn(qsn.getQsn());
			q1.setOption1(qsn.getOption1());
			q1.setOption2(qsn.getOption2());
			q1.setOption3(qsn.getOption3());
			q1.setOption4(qsn.getOption4());
			q1.setCorOption(qsn.getCorOption());
			}
		return q1;	
	}
	@Transactional
	public Questions deleteQuestion(int qsnId) {
		Questions q1 = em.find(Questions.class, qsnId);
//		if(q1!=null)
//			em.remove(q1);
//		
//		return q1;
		
		qsnRepository.delete(q1);
		
		return q1;
	}
	@Transactional
	public List<Questions> showAllQuestions() {
		String jpql="select m from Questions m";
		Query q=em.createQuery(jpql);
		List<Questions> qsnList=q.getResultList();
		return qsnList;
	}
    @Transactional
	public Questions searchQsnById(int id) {
		Optional<Questions> optional=qsnRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new QuestionsNotFoundException("question not found");
	}

}
