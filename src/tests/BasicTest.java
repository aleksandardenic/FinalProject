package tests;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.apache.commons.collections4.FactoryUtils;
import org.apache.commons.compress.utils.FileNameUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;


public abstract class BasicTest {
	
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait  waiter;
	protected String baseURL = "http://demo.yo-meals.com/";
	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";
	protected LoginPage loginPage;
	protected LocationPopupPage locationPopupPage;
	protected ProfilePage profilePage;
	protected NotificationSistemPage notificationSistemPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;
	protected AuthPage authPage;
	
	
	
	
	
	@BeforeMethod
	public void setup () {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		waiter = new WebDriverWait (driver,10);
		js = (JavascriptExecutor) driver;
		
		loginPage = new LoginPage (driver, js, waiter);
		locationPopupPage = new LocationPopupPage (driver, js, waiter);
		notificationSistemPage = new NotificationSistemPage (driver, js, waiter);
		profilePage = new ProfilePage (driver, js, waiter);
		authPage = new AuthPage (driver, js, waiter);
		mealPage = new MealPage (driver, js, waiter);
		cartSummaryPage = new CartSummaryPage (driver, js, waiter);

}
	
	@AfterMethod
	public void cleanup(ITestResult results) throws IOException {
		if (ITestResult.FAILURE == results.getStatus()) {

			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.png'").format(new Date());
			FileHandler.copy(source, new File("screenshots/" + results.getName() + "--" + fileName));
		}
		
		
	this.driver.quit();

	}
}
