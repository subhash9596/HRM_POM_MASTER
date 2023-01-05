package com.hrm.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class HomePage {
	//Create object of web driver
	WebDriver driver;
	
	//User Name 
    @FindBy(xpath = "//input[@id='txtUsername']")
    public WebElement userid;
    
    //Passwrod
    @FindBy(xpath = "//input[@id='txtPassword']")
	public WebElement password;		
	//Login Button
    @FindBy(xpath = "//input[@id='btnLogin']")
	public WebElement btnLogin;
        
    //Login Falure tool tip Messsage or User can not be empty
	@FindBy(xpath = "//span[@id='spanMessage']")
	public WebElement LoginFalureMessage;
	
	//Forgot Passweord link
	@FindBy(linkText="Forgot your password?")
    public WebElement forgotpasswordlink;

	public HomePage() {
	PageFactory.initElements(Base.driver, this);
}

}

