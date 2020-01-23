package com.tyss.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//abbr[.='Account']")
	private WebElement accountLink;
	
	@FindBy(xpath = "//a[contains(.,' Sign in')]")
	private WebElement signIn;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void signInClk()
	{
		Reporter.log("Mouse Hovering to Account link");
		Actions act = new Actions(driver);
		act.moveToElement(accountLink).perform();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(signIn));
		Reporter.log("Clicking on SingIn Link");
		signIn.click();
	}
	
	public String homePageTitle()
	{
		return driver.getTitle();
	}
}
