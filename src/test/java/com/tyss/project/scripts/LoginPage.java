package com.tyss.project.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.project.lib.BaseLib;
import com.tyss.project.lib.GenericLib;
import com.tyss.project.pages.CustomerLoginPage;
import com.tyss.project.pages.HomePage;
import com.tyss.project.pages.MyAccountPage;

public class LoginPage extends BaseLib {

	@Test
	public void tc_01() throws InterruptedException
	{
		HomePage hm = new HomePage(driver);
		Assert.assertEquals(hm.homePageTitle(), GenericLib.getExpected("Sheet1",3,4));
		hm.signInClk();
		Thread.sleep(3000);
		CustomerLoginPage clp = new CustomerLoginPage(driver);
		Assert.assertEquals(clp.customerLoginPageTitle(), GenericLib.getExpected("Sheet1",5,4));
		clp.untxtboxEnterData(GenericLib.getExecelData("Sheet1", 6, 3));
		clp.pwtxtboxEnterData(GenericLib.getExecelData("Sheet1", 7, 3));
		clp.loginBtnClick();
		MyAccountPage ma = new MyAccountPage(driver);
		Assert.assertEquals(ma.MyAccountPageTitle(), GenericLib.getExpected("Sheet1", 8, 4));
		GenericLib.takeScreenShot(driver, "MyAccountPageSS");
		Assert.assertTrue(ma.helloNameTxt().contains(GenericLib.getExpected("Sheet1", 9, 4)));
		
	}
}
