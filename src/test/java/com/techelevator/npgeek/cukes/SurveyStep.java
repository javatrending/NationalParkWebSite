package com.techelevator.npgeek.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.pageObject.ParkPage;
import com.techelevator.npgeek.pageObject.SurveyInputPage;
import com.techelevator.npgeek.pageObject.SurveyResultPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@Component
public class SurveyStep {
	private WebDriver webDriver;
	private ParkPage parkPage;
	private SurveyInputPage surveyInputPage;
	private SurveyResultPage surveyResultPage;
	
	@Autowired
	public SurveyStep(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.parkPage = parkPage;
		this.surveyInputPage = surveyInputPage;
		this.surveyResultPage = surveyResultPage;
	}
	
	@Given("^I want to vote for Grand Canyon National Park$")
	public void i_want_to_vote_for_Grand_Canyon_National_Park() throws Throwable {
	    webDriver.get("http://localhost:8080/m3-java-capstone/surveyInput");
	    parkPage.clickToTakeSurvey().chooseAPark("GCNP");
	}

	@Given("^my eamil address is apple@gmail\\.com$")
	public void my_eamil_address_is_apple_gmail_com(String emailAddress) throws Throwable {
	    surveyInputPage.enterEmailAddress(emailAddress);
	}

	@Given("^my state is Ohio$")
	public void my_state_is_Ohio(String state) throws Throwable {
	    surveyInputPage.chooseAState(state);
	}

	@Given("^my activity level is Active$")
	public void my_activity_level_is_Active(String activityLevel) throws Throwable {
	    surveyInputPage.chooseActivityLevel(activityLevel);
	}

	@When("^I submit my vote$")
	public void i_submit_my_vote() throws Throwable {
	    surveyInputPage.submitForm();
	}

	@Then("^I will see result page$")
	public void i_will_see_result_page(String expectedPage) throws Throwable {
	    Assert.assertEquals(expectedPage, surveyResultPage);
	}

}
