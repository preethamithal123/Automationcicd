package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.LandingPage;

public class BaseTest {
	public   WebDriver driver;
	   public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\rahulshettyacademy\\resourses\\globleData.properties");
		prop.load(fis);
		String browsername =System.getProperty("browser")!=null?System.getProperty("browser"): prop.getProperty("browser");
		
		//String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
	public List<HashMap<String, String>> getJasonDtaToHashMap(File filePath) throws IOException {
		
	String jsonContent=	FileUtils.readFileToString(filePath);
		
	ObjectMapper mapper=new ObjectMapper();
List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	return data;
	}

	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();

		landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;

	}
	
	@Test
	public String getScreenShot(String testcaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("uesr.dir")+"//resourse"+testcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("uesr.dir")+"//resourse"+testcaseName+".png";
		
		
	}
	
	
	

	@AfterMethod(alwaysRun=true)
	public void tearDown() {

		driver.close();
		

	}

}
