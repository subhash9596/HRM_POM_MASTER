package com.hrm.admin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class AddUserPage extends Base {

	// Add User
	// User Role
	@FindBy(xpath = "//select[@id='systemUser_userType']")
	public WebElement userrole;
	// Employee Name
	@FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
	public WebElement employeename;
	// User Name
	@FindBy(xpath = "//input[@id='systemUser_userName']")
	public WebElement username;
	// Status
	@FindBy(xpath = "//select[@id='systemUser_status']")
	public WebElement satus;
	// Password
	@FindBy(xpath = "//input[@id='systemUser_password']")
	public WebElement password;
	// Conform Password
	@FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
	public WebElement conformpassword;

	// Save Btn
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement btnsave;
	// Cancel Button
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement btncancel;

	// Constructor
	public AddUserPage() {
		PageFactory.initElements(driver, this);
	}

}
