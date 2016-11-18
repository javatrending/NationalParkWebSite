package com.techelevator.npgeek.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.pageObject.ParkDetailPage;
import com.techelevator.npgeek.pageObject.ParkPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Component
public class ParkStep {
	
	private ParkPage parkPage;
	private WebDriver webDriver;
	private ParkDetailPage parkDetailPage;
	
	@Autowired
	public ParkStep(WebDriver webDriver) {
		this.parkPage = new ParkPage(webDriver);
		this.webDriver = webDriver;
		this.parkDetailPage = new ParkDetailPage(webDriver);	
	}	
	
	@Given("^I want to see park detail for Cuyahoga Valley National Park$")
	public void i_want_to_see_park_detail_for_Cuyahoga_Valley_National_Park() throws Throwable {
	    webDriver.get("http://localhost:8080/m3-java-capstone/");
	}

	@When("^I click on park image$")
	public void i_click_on_park_image(String parkCode) throws Throwable {
	    parkPage.clickParkImageLink(parkCode);
	}

	@When("^I request for park code CVNP$")
	public void i_request_for_park_code_CVNP() throws Throwable {
	    parkPage.clickParkImageLink("CVNP");

	}

	@Then("^see parkDetail page for Cuyahoga Valley National Park$")
	public void see_parkDetail_page_for_Cuyahoga_Valley_National_Park(String expectedParkName) throws Throwable {
	    Assert.assertEquals(expectedParkName,"Cuyahoga Valley National Park");
	}

}
