//This class used to provide the data to test
package com.hrm.dataprovider;

import org.testng.annotations.DataProvider;

import com.hrm.baseclass.Base;
import com.hrm.utilities.ExcelUtility;

public class StaticDataProvider extends Base {
	static String excle_path = "src/test/resources/TestData.xlsx";

	// Login Test Data
	@DataProvider(name = "Login_Data")
	public Object[][] loginTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "Login");
	}

	// ForGot Password Test Data
	@DataProvider(name = "ForgotPwd")
	public Object[][] ForgotPwdTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "ForGotPassword");
	}

	// Search User Test Data
	@DataProvider(name = "searchUser")
	public Object[][] searchUserTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "SearchUser");
	}

	// delete User Test Data
	@DataProvider(name = "deleteUser")
	public Object[][] deletteUserTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "DelUser");
	}
}
