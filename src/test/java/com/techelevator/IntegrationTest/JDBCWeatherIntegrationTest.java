package com.techelevator.IntegrationTest;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.Dao.JdbcWeatherDao;
import com.techelevator.npgeek.model.Dao.WeatherDao;




public class JDBCWeatherIntegrationTest extends DAOIntegrationTest {
	WeatherDao weatherDao;
	@Before
	public void setupDAO() {
		DataSource dataSource = getDataSource();
		weatherDao = new JdbcWeatherDao(dataSource);
		
	}
	@Test
	public void dao_returns_all_weather_details(){
		List<Weather> weather= weatherDao.getWeatherDetails("CVNP");
		Assert.assertEquals(38,weather.get(0).getLow());
		Assert.assertEquals(62, weather.get(0).getHigh());
		Assert.assertEquals("rain", weather.get(0).getForecast());
		Assert.assertEquals(1, weather.get(0).getFiveDayForecastValue());
		Assert.assertEquals(5, weather.size());
		
		
	}
	

}
