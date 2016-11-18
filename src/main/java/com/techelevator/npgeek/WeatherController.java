package com.techelevator.npgeek;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.Dao.WeatherDao;

@Controller
@SessionAttributes("choice")
public class WeatherController {
	
	private WeatherDao weatherDao;
	
	@Autowired
	public WeatherController(WeatherDao weatherDao) {
	this.weatherDao = weatherDao;
	}
	
	@RequestMapping("/weather")
	public String showWeatherPage(@RequestParam String parkCode, ModelMap model){
		List<Weather> weatherDetail= weatherDao.getWeatherDetails(parkCode);
		model.put("weatherDetail", weatherDetail);
		Weather today = weatherDao.getTodayWeather(parkCode);
		model.addAttribute("today", today);
		return "weather";
	}
	
	@RequestMapping(path="/weather", method=RequestMethod.POST)
	public String changePreference(@RequestParam String choice,@RequestParam String parkCode, ModelMap model) {
		List<Weather> weatherDetail= weatherDao.getWeatherDetails(parkCode);
		Weather today = weatherDao.getTodayWeather(parkCode);
		today.setChoice(choice);
		for (Weather weather : weatherDetail) {
			weather.setChoice(choice);
		}
		model.put("weatherDetail", weatherDetail);
		model.addAttribute("today", today);
		model.addAttribute("choice",choice);//Session Attribute
		return "weather";
	}
	


}
