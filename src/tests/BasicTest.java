package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		js = (JavascriptExecutor) driver;
		
		loginPage = new LoginPage (driver, js, null);
		locationPopupPage = new LocationPopupPage (driver, js, null);
		notificationSistemPage = new NotificationSistemPage (driver, js, null);
		profilePage = new ProfilePage (driver, js, null);
		authPage = new AuthPage (driver, js, null);

}
	
	@AfterMethod
	public void cleanup () {
		
//	this.driver.quit();

	}
}
