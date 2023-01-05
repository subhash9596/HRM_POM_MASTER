package com.hrm.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrm.baseclass.Base;

public class ExtendReport  {
	public static ExtentSparkReporter  htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public void configureReport()
	{
		ConfigReader readConfig = new ConfigReader();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "HRMTestReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("user name:", "Prachi");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("HRM Report");
		htmlReporter.config().setReportName("HRM");
		htmlReporter.config().setTheme(Theme.STANDARD);
	
	}

}
