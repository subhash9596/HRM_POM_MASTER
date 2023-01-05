package com.hrm.dataprovider;

import org.testng.annotations.DataProvider;

import com.hrm.baseclass.Base;
import com.hrm.utilities.ExcelUtility;



public class StaticDataProvider extends Base {
	static String excle_path = "src/test/resources/TestData.xlsx";
	
	@DataProvider(name="Login_Data")
	  public Object[][] loginTestData(){
		  return ExcelUtility.excelIntoArray(excle_path,"Login");
	  }
	
}

