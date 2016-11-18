package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Dao.JdbcParkDao;


@Controller
public class ParkController {
	
	private JdbcParkDao jdbcParkDao;
	
	@Autowired
	public ParkController(JdbcParkDao jdbcParkDao) {
	this.jdbcParkDao = jdbcParkDao;
	}
	
	@RequestMapping({"/","/homePage"})
	public String showHomePage(ModelMap model) {
		List<Park> parkList = jdbcParkDao.getAllParks();
		model.addAttribute("parkList", parkList);
		return "homePage";
	}
	
	
	
	
	
	

}
