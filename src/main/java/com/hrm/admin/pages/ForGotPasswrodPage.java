package com.hrm.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class ForGotPasswrodPage {
  //create object of webdriver
	WebDriver driver;
	//Username
	@FindBy(xpath = "//input[@name='securityAuthentication[userName]']")
	public WebElement orangehrmusername;
	//Reset Button
	@FindBy(xpath = "//input[@name='button']")
	public WebElement resetpassword;
	//Cancel Button
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbutton;
	
	public ForGotPasswrodPage() {
		PageFactory.initElements(Base.driver, this);
	}

}