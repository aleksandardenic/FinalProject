package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {
	
	public LocationPopupPage (WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public WebElement getLocationHeader () {
		return driver.findElement(By.xpath("//*[@class=\"header__secondary\"]/div/div/div/div/a"));
	    }
	
	public WebElement getLocationHeaderClose () {
		return driver.findElement(By.xpath("//*[@class=\"model-box-mid location-search\"]/a"));
	    }
	
	public WebElement getKeyword () {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	    }
	
	public WebElement getLocationItem (String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	    }
	
	public WebElement getLocationInput () {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	    }
	
	public WebElement getSubmit () {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));

	    }
	
	public void openLocation () {
		this.getLocationHeader().click();
	}
	
	
	public void selectLocation (String locationName) {
		this.getKeyword().click();
		String dataValue = getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", getLocationInput(), dataValue);
		js.executeScript("arguments[0].click();", getSubmit());
	}
	
	public void closeLocation () {
		this.getLocationHeaderClose().click();
	}
	
	
	
	

}
