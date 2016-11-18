package com.techelevator.npgeek.model.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;

@Component
public class JdbcParkDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			Park park = new Park();
			park.setParkCode(results.getString("parkCode"));
			park.setParkName(results.getString("parkName"));
			park.setState(results.getString("state"));
			park.setParkDescription(results.getString("parkDescription"));
			
			allParks.add(park);
		}
		return allParks;
	}
	
	@Override
	public Park getParkDetailsByParkCode(String parkCode) {
		Park park = new Park();
		String sqlSelectParkDetails = "SELECT * FROM park WHERE parkCode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkDetails, parkCode);
		while(results.next()) {
			park.setParkCode(results.getString("parkCode").toUpperCase());
			park.setParkName(results.getString("parkName"));
			park.setState(results.getString("state"));
			park.setParkDescription(results.getString("parkDescription"));
			park.setAcreage(results.getInt("acreage"));
			park.setElevationInFeet(results.getInt("elevationInFeet"));
			park.setMilesOfTrail(results.getDouble("milesOfTrail"));
			park.setNumberOfCampsites(results.getInt("numberOfCampsites"));
			park.setClimate(results.getString("climate"));
			park.setYearFounded(results.getInt("yearFounded"));
			park.setAnnualVisitorCount(results.getInt("annualVisitorCount"));
			park.setInspirationalQuote(results.getString("inspirationalQuote"));
			park.setInspirationalQuoteSource(results.getString("inspirationalQuoteSource"));
			park.setEntryFee(results.getInt("entryFee"));
			park.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
	
		}
			return park;
		
	}
	
}
