package com.techelevator.npgeek.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParkPage {
	
	private WebDriver webDriver;
	
	public ParkPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public ParkDetailPage clickParkImageLink(String parkCode) {
		WebElement parkImageLink = webDriver.findElement(By.id("parkImage"));
		parkImageLink.click();
		return new ParkDetailPage(webDriver);
	}
	
	public ParkDetailPage clickParkNameLink(String parkCode) {
		WebElement parkNameLink = webDriver.findElement(By.className("parkName"));
		parkNameLink.click();
		return new ParkDetailPage(webDriver);
	}
	
	public SurveyInputPage clickToTakeSurvey() {
		WebElement surveyLink = webDriver.findElement(By.className("surveyButton"));
		surveyLink.click();
		return new SurveyInputPage(webDriver);
	}
	
	

}
