package com.techelevator.IntegrationTest;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public abstract class DAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JdbcTemplate template;

	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setUp() {
		template=new JdbcTemplate(dataSource);
        clearDatabase();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	/* This method provides access to the DataSource for subclasses so that 
	 * they can instantiate a DAO for testing */
	protected DataSource getDataSource() {
		return dataSource;
	}
	
	protected JdbcTemplate getTemplate() {
		return template;
	}
	
	protected void clearDatabase() {
//		template.update("DELETE FROM park");
//		template.update("DELETE FROM weather");
//		template.update("DELETE FROM survey_result");
	}
	
	protected void addParksToDatabase(int numberOfParks) {
		for (int i = 0; i < numberOfParks; i++) {
			String sqlInsertPark = "INSERT INTO park (parkCode, parkName, state, acreage,elevationinfeet,milesoftrail,numberofcampsites,climate,yearfounded, annualvisitorcount,inspirationalquote,inspirationalquotesource ,parkdescription,entryfee,numberofanimalspecies) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			getTemplate().update(sqlInsertPark, "Park" + i,"ParkName"+i,"Cleveland", Math.random(), Math.random(),Math.random(),Math.random(),"rain",Math.random(),Math.random(),"inspirationalquote","inspirationalquotesource",
					"A nice park.",Math.random(),Math.random());
		}
	}

	protected void addParkToDatabase() {
		addParkToDatabase("Generic park");
	}

//	protected void addParkToDatabase(String name) {
//		String sqlInsertPark = "INSERT INTO park (parkCode, parkName, state, acreage,elevationinfeet,milesoftrail,numberofcampsites,climate,yearfounded, annualvisitorcount,inspirationalquoate,inspirationalquotesource ,parkdescription,entryfee,numberofanimalspecies) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		getTemplate().update(sqlInsertPark, "ParkCode",name,"Cleveland", Math.random(), Math.random(),Math.random(),Math.random(),"rain",Math.random(),Math.random(),"inspirationalquoate","inspirationalquotesource",
//				"A nice park.",Math.random(),Math.random());
//	}
	
	protected void addParkToDatabase(String parkCode) {
		String sqlInsertPark = "INSERT INTO park (parkCode, parkName, state, acreage,elevationinfeet,milesoftrail,numberofcampsites,climate,yearfounded, annualvisitorcount,inspirationalquote,inspirationalquotesource ,parkdescription,entryfee,numberofanimalspecies) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		getTemplate().update(sqlInsertPark, parkCode,"ParkName","Cleveland", Math.random(), Math.random(),Math.random(),Math.random(),"rain",Math.random(),Math.random(),"inspirationalquote","inspirationalquotesource",
				"A nice park.",Math.random(),Math.random());
	}
	
	protected void addWeatherToDatabase(String parkCode) {
		String sqlInsertWeather = "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast) VALUES (?,?,?,?,?)";
		getTemplate().update(sqlInsertWeather, parkCode,1, Math.random(), Math.random(),"sunny");
		getTemplate().update(sqlInsertWeather, parkCode,2, Math.random(), Math.random(),"snow");
		getTemplate().update(sqlInsertWeather, parkCode,3, Math.random(), Math.random(),"rain");
		getTemplate().update(sqlInsertWeather, parkCode,4, Math.random(), Math.random(),"thunderstorms");
		getTemplate().update(sqlInsertWeather, parkCode,5, Math.random(), Math.random(),"cloudy");
		
	}
	
//	protected void addCampgroundToDatabase(Long parkId,Long campgroundId) {
//		String sqlInsertCampground = "INSERT INTO weather (campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (?,?,?,?,?,?)";
//		getTemplate().update(sqlInsertCampground,campgroundId, parkId, "Campground", 01, 01, 1);
//	}
	
	protected void addSurveyResultToDatabase(String parkCode) {
		
		String sqlInsertSurveyResult = "INSERT INTO survey_result (parkcode,emailaddress,state,activitylevel) VALUES (?,?,?,?,?)";
		getTemplate().update(sqlInsertSurveyResult,parkCode,"test@gmail.com","Ohio","h");
	}
	
//	protected void addReservationToDatabase(Long siteId, String name, LocalDate start, LocalDate end) {
//		String sqlInsertReservation = "INSERT INTO reservation(site_id, name, from_date, to_date) VALUES (?,?,?,?)";
//		getTemplate().update(sqlInsertReservation, siteId, name, start, end);
//	}
//	
//	protected void addCampsiteToDatabase(Long campgroundId,Long campsiteId) {
//		// max_occupancy, accessible, max_rv_length, utilities
//		String sqlInsertCampsite = "INSERT INTO site (campground_id, site_number,site_id) VALUES (?,?,?)";
//		getTemplate().update(sqlInsertCampsite, campgroundId,1,campsiteId);
	}	

