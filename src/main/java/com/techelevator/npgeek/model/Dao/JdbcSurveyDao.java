package com.techelevator.npgeek.model.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Survey;

@Component
public class JdbcSurveyDao implements SurveyDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Survey> getSurveyResult() {
		List<Survey> surveyList = new ArrayList<>();
		String sqlSelectAllPost = "SELECT COUNT(survey_result.parkCode), park.parkName, park.parkCode FROM survey_result "
									+ "JOIN park ON park.parkCode=survey_result.parkCode "
									+ "GROUP BY park.parkName, park.parkCode ORDER BY count desc LIMIT 3;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPost);
		while(results.next()) {
			Survey survey = new Survey();
			survey.setParkName(results.getString("parkName"));
			survey.setParkCode(results.getString("parkCode"));
			surveyList.add(survey);
		}
		return surveyList;
	}

	@Override
	public void save(Survey post) {
		int surveyId = getNextId();
		String sqlInsertAllPost = "INSERT INTO survey_result(surveyId, parkCode, emailAddress, state, activityLevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertAllPost,surveyId, post.getParkCode(), post.getEmailAddress(), post.getState(), post.getActivityLevel());
		post.setSurveyId(surveyId);
	}

	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int surveyId; 
		if(results.next()) {
			surveyId = results.getInt(1);
		} else {
			throw new RuntimeException("unable to select next surveyId from sequence");
		}
		return surveyId;
	}
	
	

}
