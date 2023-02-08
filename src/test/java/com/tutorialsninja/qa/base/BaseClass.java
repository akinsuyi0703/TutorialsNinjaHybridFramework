package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;




public class BaseClass {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	
	public BaseClass() {
		
		prop=new Properties();
		File proFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		dataProp=new Properties();
		File dataProFile=new File("./src/main/java/com/tutorialsninja/qa/testData/testData.properties");
		
		
		try {
			FileInputStream dataFis = new FileInputStream(dataProFile);
			dataProp.load(dataFis);
		} catch (Throwable e ) {
			
			e.printStackTrace();
		}
		
		try {
		FileInputStream fis = new FileInputStream(proFile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
			
		}
	}

	
	public WebDriver initializeBrowserAndApplicationURL(String browserName) {
		
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");//Timed out receiving message from renderer:
		
		        if ( browserName.equalsIgnoreCase("chrome")) {
		        
					driver=new ChromeDriver();
					
				}else if (browserName.equalsIgnoreCase("firefox")) {
					
					driver=new FirefoxDriver();
					
					
				}else if(browserName.equalsIgnoreCase("edge")) {
					
					driver=new EdgeDriver();
				}
				else {
					System.out.println("We do not support this browser");
					
			 }
			   
			   driver.manage().window().maximize();
			   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICITY_WAIT_TIME));
			   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
			   driver.get(prop.getProperty("url"));
			  
			   return driver;
		
		
	}

}
