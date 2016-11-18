package com.techelevator.npgeek.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WeatherPage {
	
	private WebDriver webDriver;

	public WeatherPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public WeatherPage chooseTemperature(String value) {
		Select selectTemp = new Select(webDriver.findElement(By.name("choice")));
		selectTemp.selectByVisibleText(value);
		return this;	
	}
	
	public WeatherPage submitForm() {
		WebElement submitButton = webDriver.findElement(By.id("tempPref"));
		submitButton.click();
		return this;
	}

}
