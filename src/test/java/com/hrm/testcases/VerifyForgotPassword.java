package com.hrm.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.admin.pages.ForGotPassword;
import com.hrm.admin.pages.ForGotPasswrodPage;
import com.hrm.admin.pages.HomePage;
import com.hrm.baseclass.Base;
import com.hrm.dataProvider.std;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ConfigReader;
import com.hrm.utilities.ExtendReport;

public class VerifyForgotPassword extends Base {
	@Test
		public void passWordRest() {
		
		    logger.info("****TestCase Verify ForGot Password starts*****");
			HomePage homepage = new HomePage();
			ForGotPasswrodPage forgotpassword = new ForGotPasswrodPage();
			logger.info("Click on Forgot Password Link");
			CommanMethods.click(homepage.forgotpasswordlink);
			logger.info("Enter Username");
			CommanMethods.sendText(forgotpassword.orangehrmusername, "test");
			logger.info("Click on ResetPassword button");
			CommanMethods.click(forgotpassword.resetpassword);
			// Get Text
			logger.info("Validation - Verify Exp and Act Result");
			String actResuelt = "test";
			String expResult = "Reset Password link sent successfully";
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(actResuelt, expResult);
			softassert.assertAll();
			
		
		}	
	}



