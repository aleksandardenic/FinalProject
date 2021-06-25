package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	
	@Test (priority = 1)
	public void editProfile () throws InterruptedException  {
		driver.get(baseURL + "/guest-user/login-form");
		
		locationPopupPage.closeLocation();
		loginPage.login(username, password);
		
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Login Successfull"));
		
		
		driver.get(baseURL + "/member/profile");
	
		profilePage.changeInformation("Ime", "Prezime", "adresa", "46547547", 
				"3454", "India", "Bihar", "Ara");
		
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Setup Successful"));
		
		authPage.logingOut();
		
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Logout Successfull!"));
		
	}
	
	@Test (priority = 2)
	public void changeProfile () throws IOException, InterruptedException {
		
        driver.get(baseURL + "/guest-user/login-form");
		
		locationPopupPage.closeLocation();
		loginPage.login(username, password);
		
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Login Successfull"));
		
		driver.get(baseURL + "/member/profile");
		
		String imgPath = new File("./img/slika .jpg").getCanonicalPath();

		profilePage.uploadPhoto(imgPath);
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Profile Image Uploaded Successfully"));
		Thread.sleep(1000);
		
		profilePage.removePhoto();
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Profile Image Deleted Successfully"));
		Thread.sleep(1000);
		
		authPage.logingOut();
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Logout Successfull!"));
	}

}
