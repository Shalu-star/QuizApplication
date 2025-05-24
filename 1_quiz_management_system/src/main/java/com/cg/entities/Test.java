package com.cg.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class Test {
	@Id
	private int testId;
	private int marks;
	
	@OneToOne//(mappedBy = "subject")// one subject has one test
	@JoinColumn(name = "SUB_ID")
	private Subject subject;
	@OneToOne//(mappedBy = "student")//One student one test
	@JoinColumn(name = "STUD_ID")
	private Student student;
//	@OneToMany// one subject has many qsns
//	@JoinColumn(name = "TEST_ID")
//	private List<Questions> qsnList;
//	public List<Questions> getQsnList() {
//		return qsnList;
//	}
//	public void setQsnList(Questions qsn) {
//		this.qsnList = (List<Questions>) qsn;
//	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	
	
    
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
}
