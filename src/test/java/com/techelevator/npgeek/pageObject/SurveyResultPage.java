package com.techelevator.npgeek.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SurveyResultPage {
	
	private WebDriver webDriver;

	public SurveyResultPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String getParkCode() {
		return webDriver.findElement(By.id("parkCode")).getText();
	}
	
	public String getParkName() {
		return webDriver.findElement(By.id("parkName")).getText();
	}
}
