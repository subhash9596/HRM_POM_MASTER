package com.hrm.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.admin.pages.ForGotPasswrodPage;
import com.hrm.admin.pages.HomePage;
import com.hrm.baseclass.Base;
import com.hrm.dataprovider.StaticDataProvider;
import com.hrm.utilities.CommanMethods;


public class VerifyForgotPassword extends Base {
	@Test(dataProviderClass =StaticDataProvider.class,dataProvider = "ForgotPwd")
		public void passWordRest(String OrangeHRMUsername ) {
		    logger.info("*********TestCase Verify ForGot Password starts**********");
			HomePage homepage = new HomePage();
			ForGotPasswrodPage forgotpassword = new ForGotPasswrodPage();
			logger.info("Click on Forgot Password Link");
			CommanMethods.click(homepage.forgotpasswordlink);
			logger.info("Enter Username");
			CommanMethods.sendText(forgotpassword.orangehrmusername,OrangeHRMUsername);
			logger.info("Click on ResetPassword button");
			CommanMethods.click(forgotpassword.resetpassword);
		
			logger.info("Validation - Verify Exp and Act Result");
			String actResuelt = "test";
			String expResult = "Reset Password link sent successfully";
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(actResuelt, expResult);
			softassert.assertAll();
			
		
		}	
	}



