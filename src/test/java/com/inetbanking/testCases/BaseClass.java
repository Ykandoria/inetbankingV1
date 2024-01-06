package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	//Object for ReadConfig class
	ReadConfig readconfig = new ReadConfig();	//ReadConfig() constructor will be invoked and file will be read.
	
	//Common variables required for all the test cases
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	/*public String baseURL = "https://demo.guru99.com/v4/index.php";
	public String username = "mngr545122";
	public String password = "UtuqepY";
	public static WebDriver driver;
	public static Logger logger;*/
	
	//Common methods which are required for every test case
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)		//Responsible for launching the browser
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		//System.setProperty("webdriver.chrome.driver", "E:\\LearningJava\\inetBankingV1\\Drivers\\chromedriver.exe");
		//System.getProperty("user.dir") gives the project home path appended by the chromedriver.exe to avoid mentioning the whole exe path
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.get(baseURL);	//Opening the URL
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
