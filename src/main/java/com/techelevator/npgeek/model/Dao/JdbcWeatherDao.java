package com.techelevator.npgeek.model.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Weather;
@Component
public class JdbcWeatherDao implements WeatherDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherDetails(String parkCode) {
		List<Weather> weatherDetails = new ArrayList<>();
		String sqlSelectWeatherDetails = "SELECT * FROM weather WHERE parkCode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherDetails, parkCode);
		while(results.next()) {
			Weather weather= new Weather();
			weather.setParkCode(results.getString("parkCode"));
			weather.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
			weather.setLow(results.getInt("low"));
			weather.setHigh(results.getInt("high"));
			weather.setForecast(results.getString("forecast"));
			weatherDetails.add(weather);
			
		}
		return weatherDetails;
	}

	@Override
	public Weather getTodayWeather(String parkCode) {
		Weather today= new Weather();
		String sqlSelectWeatherDetails = "SELECT park.parkName,weather.parkCode,weather.low,weather.high,weather.fivedayforecastvalue,weather.forecast FROM weather JOIN park ON park.parkCode=weather.parkCode WHERE park.parkCode=? AND fiveDayForecastValue=1"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherDetails, parkCode);
		while(results.next()) {
			today.setParkCode(results.getString("parkCode"));
			today.setParkName(results.getString("parkName"));
			today.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
			today.setLow(results.getInt("low"));
			today.setHigh(results.getInt("high"));
			today.setForecast(results.getString("forecast"));
			
		}
		return today;	
	}
	

}
