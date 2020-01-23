package com.tyss.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CustomerLoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@title='Email Address']")
	private WebElement untxtbox;
	
	@FindBy(xpath = "//input[@title='Password']")
	private WebElement pwtxtbox;
	
	@FindBy(xpath = "//span[.='Login']")
	private WebElement loginBtn;

	public CustomerLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void untxtboxEnterData(String data)
	{
		Reporter.log("Entering the Username");
		untxtbox.sendKeys(data);
	}
	
	public void pwtxtboxEnterData(String data)
	{
		Reporter.log("Entering the Password");
		pwtxtbox.sendKeys(data);
	}
	
	public void loginBtnClick()
	{
		Reporter.log("Clicking on the login Button");
		loginBtn.click();
	}
	
	public String customerLoginPageTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Customer Login"));
		return driver.getTitle();
	}
	
	

}
