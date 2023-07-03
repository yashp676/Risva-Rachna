package Amazon_Watch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01 {
WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@Test(priority = 1)
	public void WatchDetails() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Wrist Watches");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[contains(@class,'a-size-base a-color-base') and text()='Analogue']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'a-size-base a-color-base') and text()='Titan']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'a-size-base a-color-base') and text()='Leather']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'a-size-base a-color-base') and text()='25% Off or more']")).click();
	}	 
		
		@Test(priority = 2)
		public void FifthElement() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@data-index]"), 4));
	        WebElement fifthElement = driver.findElements(By.xpath("//div[@data-index]")).get(4);
	        fifthElement.click();
	        System.out.println(fifthElement.getText());
            
		}
		@AfterTest
		public void teardown() {
			driver.quit();
		}
     
	}
	

