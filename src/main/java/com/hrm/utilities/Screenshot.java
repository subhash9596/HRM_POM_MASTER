
package com.hrm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hrm.baseclass.Base;

public class Screenshot extends Base {

	public static String screenshotsSubFolderName;

	public static String captureScreenshot(String fileName) {
		if (screenshotsSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HHmmss");
			screenshotsSubFolderName = myDateObj.format(myFormatObj);
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + screenshotsSubFolderName + "/" + fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();

		}
		return destFile.getAbsolutePath();
	}

}
