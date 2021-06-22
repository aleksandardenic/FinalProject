package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
		
	}

	public WebElement getClick () {
		return driver.findElement(By.xpath("//*[@class=\"right-head\"]/div[2]"));
	    }
	
	public WebElement getClickDown () {
		return driver.findElement(By.xpath("//*[@class=\"right-head\"]/div[2]/ul/li/div/ul/li[2]"));
	    }
	
	public void logingOut () {
		this.getClick().click();
		this.getClickDown().click();
	}
	

	

}
