package com.cg.dao;
import java.util.List;

import com.cg.entities.Subject;

public interface SubjectDao {
	Subject addSubject(Subject subject);
	Subject deleteSubject(int subId);
	List<Subject> showAllSubject();
	Subject searchSubjectById(int subId);

}
