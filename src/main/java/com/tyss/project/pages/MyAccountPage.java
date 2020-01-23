package com.tyss.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MyAccountPage {
	WebDriver driver;
	@FindBy(xpath = "//p[@class='hello']/strong")
	private WebElement helloName;

	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String helloNameTxt()
	{
		Reporter.log("Retriving the Welcome Name");
		return helloName.getText();
	}
	
	public String MyAccountPageTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("My Account"));
		return driver.getTitle();
	}
	

}
