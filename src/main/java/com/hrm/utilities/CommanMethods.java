package com.hrm.utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.hrm.baseclass.Base;

public class CommanMethods extends Base {
	/**
	 * Method that clears and sends keys
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void getText(WebElement element) {
		element.getText();

	}

	/**
	 * All method from select class
	 */

	/**
	 * This method is used to select value form visible test
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectValueByVisibleText(WebElement element, String value) {
		new Select(element).selectByVisibleText(value);
	}

	/**
	 * This method is used to select value form index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectValueByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	/**
	 * This method is used to select by value by value
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectByValueByValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	/**
	 * This method is used get selected value
	 * 
	 * @param element
	 */
	public static String getSelectedValue(WebElement element) {
		return new Select(element).getFirstSelectedOption().getText();
	}

	/**
	 * This method is used to print all value
	 * 
	 * @param element
	 */
	public static void printAllValue(WebElement element) {
		List<WebElement> ls = new Select(element).getOptions();

		for (WebElement abc : ls) {
			System.out.println(abc.getText());
		}
	}

	/**
	 * This method is used to count total drop-down list
	 * 
	 * @param element
	 */
	public static int countTotalDPList(WebElement element) {
		return new Select(element).getOptions().size();

	}

	/**
	 * This method is used to check specific value present
	 * 
	 * @param element
	 * @param value
	 */
	public static void checkSpecificValuePresent(WebElement element, String value) {
		List<WebElement> ls = new Select(element).getOptions();

		for (WebElement abc : ls) {
			if (abc.getText().contains(value)) {
				System.out.println("Value is Present " + abc.getText());
			}
		}
	}

	/**
	 * Alert Method
	 */
	/**
	 * This method is used to click on Ok button on alert popup
	 */
	public static void clickOnOkButton() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to click on click button on alert popup
	 */
	public static void clickOnCancel() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to enter data on alert box
	 * 
	 * @param value
	 */
	public static void enterData(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/**
	 * This method is used to capture alert text on alert popup box
	 */
	public static String captureText() {
		return driver.switchTo().alert().getText();
	}

	/**
	 * All methods from actions class
	 *
	 */

	/**
	 * This method is used to click on element
	 * 
	 * @param element
	 */
	public static void clickOnElement(WebElement element) {
		new Actions(driver).click(element).build().perform();
	}

	/**
	 * This method is used to double click on element
	 * 
	 * @param element
	 */
	public static void doubleClickOnElement(WebElement element) {
		new Actions(driver).doubleClick(element).build().perform();
	}

	/**
	 * This method is used to right click on element
	 * 
	 * @param element
	 */
	public static void rightClickOnElement(WebElement element) {
		new Actions(driver).contextClick(element).build().perform();
	}

	/**
	 * This method is used to drag and drop
	 * 
	 * @param src
	 * @param trg
	 */
	public static void dragAndDrop(WebElement src, WebElement trg) {

		new Actions(driver).dragAndDrop(src, trg).build().perform();
	}

	/**
	 * This method is used to mouse over
	 * 
	 * @param element
	 */
	public static void mouseOver(WebElement element) {
		new Actions(driver).moveToElement(element).build().perform();
	}

	/**
	 * This method is used to click on Hold element
	 * 
	 * @param element
	 */
	public static void clickOnHold(WebElement element) {
		new Actions(driver).clickAndHold(element).build().perform();
	}

	/**
	 * This method is used to release element
	 * 
	 * @param element
	 */
	public static void releaseElement(WebElement element) {
		new Actions(driver).release(element).build().perform();
	}

	/**
	 * This method is used to enter capital data
	 * 
	 * @param element
	 * @param value
	 */
	public static void enterCapitalData(WebElement element, String value) {
		new Actions(driver).keyDown(Keys.SHIFT).sendKeys(element, value).build().perform();
	}

	/**
	 * This method is used to move end of page
	 */
	public static void moveEndOfPage() {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	}

	/**
	 * This method is used to move home page
	 */
	public static void moveHomePage() {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	}

	/**
	 * Frame Methods
	 * 
	 */

	/**
	 * This method is used to switch to child frame by using frame nameorid
	 * 
	 * @param nameid
	 */
	public static WebDriver switchToChildFrameUsingName(String nameid) {
		return driver.switchTo().frame(nameid);
	}

	/**
	 * This method is used to switch to child frame by using frame index
	 * 
	 * @param index
	 */
	public static WebDriver switchToChildFrameUsingIndex(int index) {
		return driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to child frame using webelement
	 * 
	 * @param element
	 */
	public static WebDriver switchToChildFrameUsingWebElement(WebElement element) {
		return driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch to parent frame
	 *
	 */
	public static WebDriver switchToParentFrame() {
		return driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to click on element
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		element.click();
	}

	/**
	 * This method is used to seitch to topframe
	 * 
	 * @param element
	 */
	public static WebDriver switchToTopFrame() {
		return driver.switchTo().defaultContent();
	}

	/**
	 * JAVA SCRIPT open a browser,click, sendKeys,title, url , scroll down up to
	 * element, alert , border , change bg color DIT, SIT, UAT,Pre Production, post
	 * Production
	 */

	/**
	 * This method is used to open browser
	 * 
	 * @param url
	 */
	public static void openBrowser(String url) {
		((JavascriptExecutor) driver).executeScript("window.location='" + url + "';");
	}

	/**
	 * This method is used to click on element by id
	 * 
	 * @param element
	 * @param id
	 */
	public static void clickOnElementById(WebElement element, String id) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('" + id + "').click();", element);
	}

	/**
	 * This method is used to click on element
	 * 
	 * @param element
	 */
	public static void clickonElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	/**
	 * This method is used to sned data to text box
	 * 
	 * @param element
	 * @param value
	 */
	public static void sendDataToTextBox(WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
	}

	/**
	 * This method is used to getTitle
	 *
	 */
	public static String getTitle() {
		return ((JavascriptExecutor) driver).executeScript("return document.title").toString();
	}

	/**
	 * This method is used to getUrl
	 *
	 */
	public static String getUrl() {
		return ((JavascriptExecutor) driver).executeScript("return document.URL").toString();
	}

	/**
	 * This method is used to scroll upto element
	 * 
	 * @param element
	 */
	public static void scrollUptoElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method is used to border on element
	 * 
	 * @param element
	 */
	public static void borderOnElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red';", element);
	}

	/**
	 * This method is used to flash element
	 * 
	 * @param element
	 * @param color
	 */
	public static void flashElement(WebElement element, String color) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
	}

	/**
	 * This method is used to generate popup
	 * 
	 * @param value
	 */
	public static void generatePopUp(String value) {

		((JavascriptExecutor) driver).executeScript("alert('" + value + "')");
	}

	/**
	 * This method is used to refresh browser
	 *
	 */
	public static void refreshBrowser() {
		((JavascriptExecutor) driver).executeScript("history.go(0)");
	}

	/**
	 * This method is used to forward browser
	 *
	 */
	public static void forwardBrowser() {
		((JavascriptExecutor) driver).executeScript("history.go(1)");
	}

	/**
	 * This method is used to back browser
	 *
	 */
	public static void backBrowser() {
		((JavascriptExecutor) driver).executeScript("history.go(-1)");
	}

}
