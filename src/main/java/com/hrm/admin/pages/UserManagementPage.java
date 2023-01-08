package com.hrm.admin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class UserManagementPage extends Base {

	// Navigation
	// Admin Link
	@FindBy(linkText = "Admin")
	public WebElement admin;
	// User Management
	@FindBy(xpath = "//span[contains(text(),'User Management')]")
	public WebElement usermanagement;
	// Users
	@FindBy(xpath = "//a[contains(text(),'Users')]")
	public WebElement users;

	// System User Search
	// Username
	@FindBy(xpath = "//input[@id='searchSystemUser_userName']")
	public WebElement username;
	// User Role
	@FindBy(xpath = "//select[@id='searchSystemUser_userType']")
	public WebElement userrole;
	// Employee Name
	@FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
	public WebElement employeename;
	// Status
	@FindBy(xpath = "//select[@id='searchSystemUser_status']")
	public WebElement status;
    //User Table 
	//Get Username from first row 
	@FindBy(xpath = "//table[@id='resultTable']//tr[1]//td[2]")
	public WebElement getUserName;
	
	//Delete popup 
	@FindBy(xpath = "//input[@id='dialogDeleteBtn']")
	public WebElement btnOk;
	@FindBy(xpath = "//input[@class='btn reset']")
	public WebElement btncancel;
	
	// Buttons
	// Search Button
	@FindBy(xpath = "//input[@id='searchBtn']")
	public WebElement btnsearch;
	// Reset button
	@FindBy(xpath = "//input[@id='resetBtn']")
	public WebElement btnreset;
	// Add Button
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement btnadd;
	// Delete Button
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement btndelete;
	
	public UserManagementPage() {
		PageFactory.initElements(driver, this);
	}

}
