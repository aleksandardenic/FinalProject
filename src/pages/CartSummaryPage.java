package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage{

	public CartSummaryPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
		
	}
	
	public WebElement getClearAll () {
		return driver.findElement(By.xpath("//*[@class=\"cart-head\"]/a[2]"));
	}
	
	public void clearAll () {
		this.getClearAll().click();
	}

}
