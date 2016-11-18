package com.techelevator.npgeek.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SurveyInputPage {
	
	private WebDriver webDriver;

	public SurveyInputPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public SurveyInputPage chooseAPark(String value) {
		Select selectPark = new Select(webDriver.findElement(By.name("parkCode")));
		selectPark.selectByVisibleText(value);
		return this;
	}
	
	public SurveyInputPage enterEmailAddress(String emailAddress) {
		WebElement emailAddressFeild = webDriver.findElement(By.name("emailAddress"));
		emailAddressFeild.sendKeys(emailAddress);
		return this;
	}
	
	public SurveyInputPage chooseAState(String state) {
		Select selectState = new Select(webDriver.findElement(By.id("state")));
		selectState.selectByVisibleText(state);
		return this;
	}
	
	public SurveyInputPage chooseActivityLevel(String activityLevel) {
		Select selectActivityLevel = new Select(webDriver.findElement(By.id("activityLevel")));
		selectActivityLevel.selectByVisibleText(activityLevel);
		return this;
	}
	
	public SurveyResultPage submitForm() {
		WebElement submitButton = webDriver.findElement(By.id("submit"));
		submitButton.click();
		return new SurveyResultPage(webDriver);
	}

	
}
