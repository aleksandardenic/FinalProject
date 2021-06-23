package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	public NotificationSistemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
		
	}
	
	public WebElement getMessage () {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	    }
	
	public String messageText () {
		
		return this.getMessage().getText();
	}
	
	public void waitMessage () {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'system_message')]"), "style", "display: none;"));
	}
	
	public boolean textMessage () {
		List<WebElement>text = driver.findElements(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
		return text.size() > 0;
	}

}
