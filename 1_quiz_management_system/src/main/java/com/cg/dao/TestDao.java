package com.cg.dao;
import java.util.List;
import com.cg.entities.Test;
public interface TestDao {
	Test addTest(Test test);
	Test updateTest(Test t, int tId);
	Test deleteTest(int tId);
	List<Test> showAllTest();
	Test searchTestById(int id);
}