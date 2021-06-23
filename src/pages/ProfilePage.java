package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.corba.se.spi.orbutil.fsm.Action;


public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
		
	}
	
	public WebElement getFirstName () {
		return driver.findElement(By.name("user_first_name"));
	    }
	
	public WebElement getLastName () {
		return driver.findElement(By.name("user_last_name"));
	    }
	
//	public WebElement getEmail () {
//		return driver.findElement(By.name("user_email"));
//	    }
	
	public WebElement getAddress () {
		return driver.findElement(By.name("user_address"));
	    }
	
	public WebElement getPhoneNo () {
		return driver.findElement(By.name("user_phone"));
	    }
	
	public WebElement getZipCode () {
		return driver.findElement(By.name("user_zip"));
	    }
	
	public Select getCountry () {
		Select country = new Select (driver.findElement(By.name("user_country_id")));
		return country;
	}
	public Select getState () {
		Select state = new Select (driver.findElement(By.name("user_state_id")));
		return state;
	}
	public Select getCity () {
		Select city = new Select (driver.findElement(By.name("user_city")));
		return city;
	}
	
	public void selectCountry (String country) {
		getCountry().selectByVisibleText(country);
	}
	public void selectState (String state) {
		getState().selectByVisibleText(state);
	}
	public void selectCity (String city) {
		getCity().selectByVisibleText(city);
	}
	
	
	public WebElement getSaveBtn () {
		return driver.findElement(By.name("btn_submit"));
	    }
	
	
	
	public void uploadPhoto (String imagePath) {
		Actions action = new Actions (driver);
		WebElement hover = driver.findElement(By.className("avatar"));
		action.moveToElement(hover).build().perform();
		
		WebElement upload = driver.findElement(By.xpath("//a[@title='Uplaod']"));
		js.executeScript("arguments[0].click();", upload);
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imagePath);
		
	
		
	}
	
	public void removePhoto () {
		WebElement remove = driver.findElement(By.xpath("//a[@title='Remove']"));
		js.executeScript("arguments[0].click();", remove);
	}
	
	
	public void changeInformation (String firstName, String lastName, String address,
			String phoneNo, String zipCode, String country, String state, String city) throws InterruptedException {
		
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhoneNo().clear();
		this.getPhoneNo().sendKeys(phoneNo);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		
		
		
		this.selectCountry(country);
		Thread.sleep(3000);
		this.selectState(state);
		Thread.sleep(3000);
		this.selectCity(city);
		
		Thread.sleep(3000);
		this.getSaveBtn().click();
	
		
	}
	
	
	

	
	
	
	
	
	
	

}
