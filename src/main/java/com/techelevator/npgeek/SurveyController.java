package com.techelevator.npgeek;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.Dao.SurveyDao;

@Controller
public class SurveyController {
	
	private SurveyDao surveyDao;
	
	@Autowired
	public SurveyController(SurveyDao surveyDao) {
	this.surveyDao = surveyDao;
	}
	@RequestMapping("/surveyInput")
	public String showSurveyForm() {
		return "surveyInput";	
	}
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.POST)
	public String postSurvey(@RequestParam String parkCode,
							@RequestParam String emailAddress, 
							@RequestParam String state,
							@RequestParam String activityLevel, ModelMap model) {
		
		Survey survey = new Survey();
		survey.setParkCode(parkCode);
		survey.setEmailAddress(emailAddress);
		survey.setState(state);
		survey.setActivityLevel(activityLevel);
		surveyDao.save(survey);
		
		model.put("survey", survey);
		
		return "redirect:/surveyResult";	
	}
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String showSurveyPage(ModelMap model) {
		List<Survey> surveyList = surveyDao.getSurveyResult();
		model.addAttribute("surveyList", surveyList);
		return "surveyResult";
	}
	
	
}
