package com.techelevator.npgeek.model.Dao;

import java.util.List;

import com.techelevator.npgeek.model.Survey;

public interface SurveyDao {
	
	public void save(Survey post);
	public List<Survey> getSurveyResult();

}
