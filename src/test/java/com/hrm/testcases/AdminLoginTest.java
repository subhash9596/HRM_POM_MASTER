package com.hrm.testcases;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.hrm.admin.pages.HomePage;
import com.hrm.baseclass.Base;
import com.hrm.dataprovider.StaticDataProvider;
import com.hrm.utilities.CommanMethods;
import com.sun.org.slf4j.internal.Logger;

public class AdminLoginTest extends Base{
	
	@Test()
	public void hrmAdminLogin(String Username,String Passwrod ) {
		logger.info("***************TestCase Verify Login starts*****************");
		logger.info("Create Object of Home Page to call all the Elements");
		HomePage homepage = new HomePage();
		logger.info("Enter Username");
		CommanMethods.sendText(homepage.userid,Username);
		logger.info("Enter Password");
		CommanMethods.sendText(homepage.password,Passwrod);
		logger.info("CClick on Login Button");
		CommanMethods.click(homepage.btnLogin);
		
		logger.info("Validate- Acutal and Expected Result");
		String actualTitle = driver.getTitle();
		System.out.println("Title of page" + actualTitle);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("OrangeHRM", actualTitle, "titles are not matching");
		sa.assertAll();
		logger.info("***************TestCase Verify Login ends *****************");
	}
	@Test()
	public void dataDrivenTest(String Username, String Password, String ErrorMessage) {
		HomePage homepage = new HomePage();
		CommanMethods.sendText(homepage.userid, Username);
		CommanMethods.sendText(homepage.password, Password);
		CommanMethods.click(homepage.btnLogin);
		String actualerrormessage = homepage.LoginFalureMessage.getText();
		System.out.println(actualerrormessage);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ErrorMessage, actualerrormessage, "error message are not matching");
		sa.assertAll();

	}
  
}
