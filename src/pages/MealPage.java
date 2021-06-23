package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
		
	}


	public WebElement getAddToCartBtn() {
		return driver.findElement(By.xpath("//*[@class='price-feature--wrapper']/div[2]/a"));
	}

	public WebElement getQuantityBtn() {
		return driver.findElement(By.xpath("//*[@class=\"price-feature--wrapper\"]/div/ul/li[3]/input"));
	}

	public void addMealToCart(int quantity) throws InterruptedException {
		this.getQuantityBtn().sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		this.getQuantityBtn().sendKeys(String.valueOf(quantity));
		Thread.sleep(1000);
		this.getAddToCartBtn().click();

	}

	public void addFavorites() {
		driver.findElement(By.xpath("//a[@title='Favorite']")).click();
	}



}
