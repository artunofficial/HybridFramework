package com.tutorialsNinja.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReporter {
	public static ExtentReports generateExtentReport() throws Exception {
		
		//Step 1: You have to add the maven dependencies of the ExtentReports in pom.xml file
		
		//Step 2: Create the object of ExtentReports Class
		
		ExtentReports extentReport = new ExtentReports();
		
		//Step 3: Create the Object of File Class and pass the path of the .html file in the constructor
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreport.html");
		
		//Step 4: Create the object of ExtentSparkReporter and pass the reference of the file class in the constructor
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		//Step 5: Using this sparkReporter we can configure a lot of things inside the ExtentReport.html file
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TN Automation RESULTS");
		sparkReporter.config().setDocumentTitle("TNReportTitle|Automation|Results|March_24");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyy hh:mm:ss");
		
		//Step 6: We need to attach the ExtentReport with the SparkReporter
		extentReport.attachReporter(sparkReporter);
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsNinja\\config\\Config.properties");
		prop.load(ip);
		
		//Application url, browserName, validEmail, validPassword, Operating System, Java version, name of the SDET 
		extentReport.setSystemInfo("application url", prop.getProperty("url"));
		extentReport.setSystemInfo("browser name", prop.getProperty("browser"));
		extentReport.setSystemInfo("valid Email", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("valid Password", prop.getProperty("validPassword"));
		
		extentReport.setSystemInfo("java vendor", System.getProperty("java.vendor"));
		extentReport.setSystemInfo("java version", System.getProperty("java.vm.version"));
		extentReport.setSystemInfo("SDET", System.getProperty("user.namer"));
		extentReport.setSystemInfo("operating system", System.getProperty("os.version"));
		
		return extentReport;
		
	}

}
