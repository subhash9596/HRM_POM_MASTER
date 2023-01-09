package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.hrm.admin.pages.UserManagementPage;
import com.hrm.baseclass.Base;
import com.hrm.dataprovider.StaticDataProvider;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ConfigReader;

public class UserManagementTest extends Base {

	@BeforeMethod
	public void setup() {
		AdminLoginTest login = new AdminLoginTest();
		login.hrmAdminLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	}

	@Test(priority = 1,dataProviderClass = StaticDataProvider.class, dataProvider = "searchUser")
	public void searchUser(String Username, String UserRole, String EmployeeName, String Status) {

		logger.info("***** TestCase Verify search user starts *****");

		logger.info("Create object of UserManagement Page");
		UserManagementPage usermanagement = new UserManagementPage();
		logger.info("Click on Admin link");
		CommanMethods.click(usermanagement.admin);
		logger.info("Enter Username ");
		CommanMethods.sendText(usermanagement.username, Username);
		logger.info("Select User Role");
		CommanMethods.selectValueByVisibleText(usermanagement.userrole, UserRole);
		logger.info("Enter Employee Name");
		CommanMethods.sendText(usermanagement.employeename, EmployeeName);
		logger.info("Select Status");
		CommanMethods.selectValueByVisibleText(usermanagement.status, Status);
		logger.info("Click on Search button ");
		CommanMethods.click(usermanagement.btnsearch);

		// Compare Expected and Actual result
		String actResult = Username;
		String expResult = CommanMethods.getText(usermanagement.getUserName);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, expResult);
		logger.info("***** TestCase Verify search user ends *****");

	}

	@Test(priority = 2,dataProviderClass = StaticDataProvider.class, dataProvider = "deleteUser")
	public void deleteUser(String UserName) {
		
		logger.info("***** TestCase Verify delete from user tabale starts *****");
		logger.info("Create object of UserManagement Page");
		UserManagementPage usermanagement = new UserManagementPage();
		logger.info("Click on Admin link");
		CommanMethods.click(usermanagement.admin);
		// get row size
		logger.info("get Row Count");	
		int rowCoutn = driver.findElements(By.xpath("//table[@id='resultTable']//tr")).size();
		for (int i = 2; i <= rowCoutn; i++) {
			String firstname = driver.findElement(By.xpath("//table[@id='resultTable']//tr[" + i + "]/td[2]")).getText();
			
			if (firstname.contains(UserName)) {
				driver.findElement(By.xpath("//table[@id='resultTable']//tr[" + i + "]/td[1]/input")).click();
				logger.info("Click on delete button ");
				CommanMethods.click(usermanagement.btndelete);
				logger.info("Click on Ok button");
				CommanMethods.click(usermanagement.btnOk);
				break;
			}
		}
	}
}
