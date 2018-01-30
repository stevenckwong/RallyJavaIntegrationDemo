package com.stevenckwong.rallyintegration;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class TestLoginGetNameService {
	
	

	@Test
	public void test() {
		// fail("Not yet implemented");
		
		
		
		try {
			this.runTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void runTest() throws InterruptedException {
		
		// System.setProperty("webdriver.chrome.driver", "/Users/steven/Applications/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/RallyJavaIntegrationDemo/index.html");
		
		WebElement usernameBox = driver.findElement(By.name("username"));
		usernameBox.clear();
		usernameBox.sendKeys("tm1-b1@stevenckwong.com");
		
		WebElement apikeyBox = driver.findElement(By.name("apikey"));
		apikeyBox.clear();
		apikeyBox.sendKeys("_x3imUPkjQdiySkvNCrs0d03TiJhzCkkEmswt6fpHOao");
		
		//WebElement loginButton = driver.findElement(By.name("loginbutton"));
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		loginButton.click();
		
		Thread.sleep(3000);
		WebElement hiddenDisplayName = driver.findElement(By.id("displayName"));
		String displayName = hiddenDisplayName.getAttribute("value");
		System.out.println("Display Name: " + displayName);
		assertEquals("I'm Team Member 1 for B1",displayName);
		
		
		// Thread.sleep(2000);
		driver.quit();
		// driver.close();
		
	}
	

}
