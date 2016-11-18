package com.techelevator.npgeek.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParkDetailPage {
	
	private WebDriver webDriver;

	public ParkDetailPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WeatherPage clickViewFiveDaysForecastLink() {
		WebElement weatherForecastLink = webDriver.findElement(By.id("forecast"));
		weatherForecastLink.click();
		return new WeatherPage(webDriver);
	}
	
	public String getParkCode() {
		return webDriver.findElement(By.id("parkCode")).getText();
	}
	
}
