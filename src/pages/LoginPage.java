package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {
	
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	public WebElement getLogin () {
		return driver.findElement(By.name("Login"));
	    }
	
	public WebElement getUsername () {
		return driver.findElement(By.name("username"));
	}
	
	
    public WebElement getPassword () {
		return driver.findElement(By.name("password"));
	}
    
    public WebElement getRememberMe () {
    	return driver.findElement(By.name("remember_me"));
        }

    public WebElement getSubmit () {
	return driver.findElement(By.name("btn_submit"));
    }
    
    public void login (String username, String password) {
    	this.getLogin().click();
    	this.getUsername().sendKeys(username);
    	this.getPassword().sendKeys(password);
    	this.getSubmit().click();
    }

}
