package com.cg.dao;
import java.util.List;
import com.cg.entities.Questions;
public interface QuestionsDao {
	Questions addQuestion(Questions qsn);
	Questions updateQuestion(Questions qsn, int qsnId);
	Questions deleteQuestion(int qsnId);
	List<Questions> showAllQuestions();
	Questions searchQsnById(int id);
	

}
