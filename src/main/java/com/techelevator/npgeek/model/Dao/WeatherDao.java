package com.techelevator.npgeek.model.Dao;

import java.util.List;

import com.techelevator.npgeek.model.Weather;

public interface WeatherDao {
	public List<Weather> getWeatherDetails(String parkCode);
	public Weather getTodayWeather(String parkCode);


}
