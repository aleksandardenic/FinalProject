package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {
	
	@Test (priority = 1)
	public void addMealToCart() throws IOException, InterruptedException {

		driver.get ("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(500);
		locationPopupPage.closeLocation();
		Thread.sleep(500);

		mealPage.addMealToCart(2);
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("The Following Errors Occurred:"));
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Please Select Location"));	
		Thread.sleep(3000);
		locationPopupPage.openLocation();
		locationPopupPage.selectLocation("City Center - Albany");
		Thread.sleep(3000);
		mealPage.addMealToCart(2);
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Meal Added To Cart"));
	
	}

	@Test (priority = 2)
	public void addMealToFavorite() throws InterruptedException {

		driver.get ("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(500);
		locationPopupPage.closeLocation();
		Thread.sleep(500);

		mealPage.addFavorites();
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Please login first!"));
		Thread.sleep(500);

		driver.get(baseURL + "/guest-user/login-form");
		Thread.sleep(500);
		loginPage.login(username, password);
		Thread.sleep(500);
		driver.get ("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(500);
		mealPage.addFavorites();
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("Product has been added to your favorites."));
	}
	
	
	@Test (priority = 3)
	public void clearCart() throws IOException, InterruptedException {
		driver.get(baseURL + "http://demo.yo-meals.com/meals");

		locationPopupPage.selectLocation("City Center - Albany");
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");

		for (int i = 1;  i<6; i++) {
			XSSFRow row = sheet.getRow(i);
			String meal = row.getCell(0).getStringCellValue();
			int quantity = (int) row.getCell(1).getNumericCellValue();
			driver.navigate().to(meal);
			mealPage.addMealToCart(quantity);
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(this.notificationSistemPage.messageText().contains("Meal Added To Cart"));
			softAssert.assertAll();

		}

		cartSummaryPage.clearAll();
		Assert.assertTrue(this.notificationSistemPage.messageText().contains("All meals removed from Cart successfully"),
				"Message is not displayed");

	} 

	}

