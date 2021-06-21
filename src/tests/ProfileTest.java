package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	@Test
	public void editProfile () {
		driver.get(baseURL + "/guest-user/login-form");
		
		locationPopupPage.closeLocation();
		loginPage.login(username, password);
		
		Assert.assertTrue(this.notificationSistemPage.textMessage(), "Login Successfull");
	}

}
