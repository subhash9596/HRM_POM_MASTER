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
	// Select value from visible text
	public static void selectValueByVisibleText(WebElement element, String value) {
		new Select(element).selectByVisibleText(value);
	}
	// Select value from index
	public static void selectValueByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	// Select by value by value
	public static void selectByValueByValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	// get selected value
	public static String getSelectedValue(WebElement element) {
		return new Select(element).getFirstSelectedOption().getText();
	}

	// Print all value
	public static void printAllValue(WebElement element) {
		List<WebElement> ls = new Select(element).getOptions();

		for (WebElement abc : ls) {
			System.out.println(abc.getText());
		}
	}

	// count totalDP list
	public static int countTotalDPList(WebElement element) {
		return new Select(element).getOptions().size();

	}

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

	// it will click on Ok Button
	public static void clickOnOkButton() {
		driver.switchTo().alert().accept();
	}

	// it will click on Cancel Button
	public static void clickOnCancel() {
		driver.switchTo().alert().dismiss();
	}

	// it will enter data on alert Box
	public static void enterData(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	// it will capture alert text
	public static String captureText() {
		return driver.switchTo().alert().getText();
	}

	/**
	 * All methods from actions class
	 *
	 */

	public static void clickOnElement(WebElement element) {
		new Actions(driver).click(element).build().perform();
	}

	public static void doubleClickOnElement(WebElement element) {
		new Actions(driver).doubleClick(element).build().perform();
	}

	public static void rightClickOnElement(WebElement element) {
		new Actions(driver).contextClick(element).build().perform();
	}

	public static void dragAndDrop(WebElement src, WebElement trg) {

		new Actions(driver).dragAndDrop(src, trg).build().perform();
	}

	public static void mouseOver(WebElement element) {
		new Actions(driver).moveToElement(element).build().perform();
	}

	public static void clickOnHold(WebElement element) {
		new Actions(driver).clickAndHold(element).build().perform();
	}

	public static void releaseElement(WebElement element) {
		new Actions(driver).release(element).build().perform();
	}

	public static void enterCapitalData(WebElement element, String value) {
		new Actions(driver).keyDown(Keys.SHIFT).sendKeys(element, value).build().perform();
	}

	public static void moveEndOfPage() {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	}

	public static void moveHomePage() {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	}

	/**
	 * Frame Methods
	 */
	// switch to child frame by using frame nameorid
	public static WebDriver switchToChildFrameUsingName(String nameid) {
		return driver.switchTo().frame(nameid);
	}

	// switch to child frame by using frame index
	public static WebDriver switchToChildFrameUsingIndex(int index) {
		return driver.switchTo().frame(index);
	}

	// switch to child frame by using frame index
	public static WebDriver switchToChildFrameUsingWebElement(WebElement element) {
		return driver.switchTo().frame(element);
	}

	// switch to parent frame
	public static WebDriver switchToParentFrame() {
		return driver.switchTo().parentFrame();
	}
	public static void click(WebElement element) {
		element.click();
	}

	// switch to top frame
	public static WebDriver switchToTopFrame() {
		return driver.switchTo().defaultContent();
	}

	/**
	 * JAVA SCRIPT open a browser,click, sendKeys,title, url , scroll down up to
	 * element, alert , border , change bg color DIT, SIT, UAT,Pre Production, post
	 * Production
	 */
	public static void openBrowser(String url) {
		((JavascriptExecutor) driver).executeScript("window.location='" + url + "';");
	}

	public static void clickOnElementById(WebElement element, String id) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('" + id + "').click();", element);
	}

	public static void clickonElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static void sendDataToTextBox(WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
	}

	public static String getTitle() {
		return ((JavascriptExecutor) driver).executeScript("return document.title").toString();
	}

	public static String getUrl() {
		return ((JavascriptExecutor) driver).executeScript("return document.URL").toString();
	}

	public static void scrollUptoElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void borderOnElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red';", element);
	}

	public static void flashElement(WebElement element, String color) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
	}

	public static void generatePopUp(String value) {

		((JavascriptExecutor) driver).executeScript("alert('" + value + "')");
	}

	public static void refreshBrowser() {
		((JavascriptExecutor) driver).executeScript("history.go(0)");
	}

	public static void forwardBrowser() {
		((JavascriptExecutor) driver).executeScript("history.go(1)");
	}

	public static void backBrowser() {
		((JavascriptExecutor) driver).executeScript("history.go(-1)");
	}


}
