package com.techelevator.npgeek;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Dao.ParkDao;

@Controller
public class ParkDetailsController {
	
	private ParkDao parkDao;
	
	@Autowired
	public ParkDetailsController(ParkDao parkDao) {
		this.parkDao = parkDao;
		}
	
	@RequestMapping("/parkDetail")
	public String showParkDetailPage(@RequestParam String parkCode, ModelMap model) {
		Park park = parkDao.getParkDetailsByParkCode(parkCode);
		
		model.addAttribute("park", park);
		
		return "parkDetail";
	}

}
