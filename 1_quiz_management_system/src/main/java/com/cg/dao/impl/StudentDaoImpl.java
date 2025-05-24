package com.cg.dao.impl;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.dao.StudentDao;
import com.cg.dto.TestDTO;
import com.cg.entities.Questions;
import com.cg.entities.Student;
import com.cg.entities.Test;
import com.cg.exception.StudentNotFoundException;
import com.cg.exception.TestNotFoundException;
import com.cg.repository.StudentRepository;


@Component
public class StudentDaoImpl implements StudentDao{
	@PersistenceContext
	private EntityManager em;
    @Autowired
    private StudentRepository studRepository;
//    int id;
//	int tid;
//	String res;
	
//	public Test giveTest(int studId) {
//		int id;
//		int tid;
//		String res;
     //	Student s1=em.find(Student.class, studId);
		//Test t1 = em.find(Test.class, testId);
		//int id = t1.getStudent().getStudId();
		//if(id == studId /*&& t1.getStudent().getStudId() == studId*/) {
//			Questions q1 = em.find(Questions.class, 2000/*t1.getSubject().getSubId()*/);
//			 id = s1.getStudId();
//			 tid = t1.getTestId();
//			 res = q1.getCorOption();
		   // data = id +" "+ tid+" "+res;
		//	return t1;
		//}
//     	JSONObject obj = new JSONObject();
//     	obj.put("id", id);
//     	obj.put("tid", tid);
//     	obj.put("corOption", res);
//		return obj; 
		//return null;
//		while(s1 != null)
//		{
//		if(s1.getStudId() == studId)
//		{
//		return s1.getStudName();
//		}
//		}
//		return "successful";
     	//return null;
//	}
    @Transactional
	public Test getResult(int testId) {
		Test t = em.find(Test.class, testId);
		//System.out.println(t.getMarks());
		if(t.getTestId() == (testId)) {
			System.out.println(t.getMarks());
			return t;
		}
		throw new TestNotFoundException("test not found");
	}
	@Transactional
	public Student updateProfile(Student student, int studId) {
		Student s1=em.find(Student.class, studId);
		if(s1!=null) {
			s1.setStudName(student.getStudName());
			s1.setStudEmail(student.getStudEmail());
			s1.setStudMobNo(student.getStudMobNo());
			s1.setStudPassword(student.getStudPassword());
			}
		return s1;	
	}
	@Transactional
	public Student addStudent(Student student) {
		Student stud =studRepository.save(student);
		return stud;
	}
	@Transactional
	public Student deleteStudent(int studId) {
		Student s = em.find(Student.class, studId);
		if(s!=null)
			em.remove(s);
		return s;
	}
	@Transactional
	public List<Student> showAllStudent() {
		String jpql="select s from Student s";
		Query q=em.createQuery(jpql);
		List<Student> studList=q.getResultList();
		return studList;
	}
	@Transactional
	public Student searchStudentById(int studId) {
		Student s=em.find(Student.class , studId);
		while(s != null)
		{
		if(s.getStudId() == studId)
		{
		return s;
		}
		}
	throw new StudentNotFoundException("student not found");
	}
	@Transactional
	public Test giveTest(TestDTO dto) {
		System.out.println(dto.getTest_id()+" "+dto.getCor_option()+" "+dto.getQsn_id()+""+dto.getQsn_id()+" "+dto.getStudid()+" "+dto.getSub_id());
		Test t = em.find(Test.class, dto.getTest_id());
		Questions q = em.find(Questions.class, dto.getQsn_id());
		Student s = em.find(Student.class, dto.getStudid());
		System.out.println(dto.getCor_option());
		System.out.println(q.getCorOption());
		if(t.getTestId() != 0 ) {
			if((q.getQsnId() != 0) && (s.getStudId() != 0)) {
				if(dto.getCor_option().equals(q.getCorOption()) ) {
					int res = t.getMarks();
					res++;
					t.setMarks(res);
				}
				else {
					int res = t.getMarks();
					res--;
					t.setMarks(res);
				}
			}
			else {
				System.out.println("data not found");
			}
		}
		else {
			
		}
		return null;
	}

}
