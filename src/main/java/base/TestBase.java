package base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver; // 1
	
	public static Properties prop;   // 2
	
	public void init() { 			// 3
//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	//WebDriverManager
		
		prop = new Properties();
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationFrameworkBatchApril2022\\src\\main\\java\\config\\configuration.properties");
		prop.load(file);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("configuration file is missing");
		}
		
		String browser = prop.getProperty("browser");
		
		
		if(browser.contains("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		}
		else if(browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();			
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
