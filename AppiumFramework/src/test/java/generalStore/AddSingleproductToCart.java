package generalStore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtils.BaseTest;
import ObjectRepo.LoginPage;
import ObjectRepo.ProductsPage;

public class AddSingleproductToCart extends BaseTest{
@Test
public void addSingleproductToCart() throws InterruptedException {
	
	LoginPage loginPage = new LoginPage(driver);
	loginPage.getYourNameTxtFiled().sendKeys("sanjay");
	loginPage.loginToApp(driver, gLib,"Austria");
	ProductsPage productsPage = new ProductsPage(driver);
	productsPage.addProductToCart(gLib, "Air Jordan 9 Retro");
	
	// enter your name
//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("sanjay");
//	// enter female dropdown
//	driver.findElement(By.xpath("//*[@text='Female']")).click();
//	// select dropdown
//	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//	// scrolldown and click on text india
//	gLib.scrollingGestureToPerticularElement(driver, "Austria");
//	driver.findElement(By.xpath("//*[@text='Austria']")).click();
//	// click on lets shop button
//	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	//scroll to the shoe (Air Jordan 9 Retro)
//	gLib.scrollingGestureToPerticularElement(driver, "Air Jordan 9 Retro");
//	//click on add to cart but here there are 2 add to cart in a page
//	List<WebElement> productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
//	for(int i=0;i<productCount.size();i++)
//	{	
//		String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//		if(productName.equalsIgnoreCase("Air Jordan 9 Retro"))
//		{
//			driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
//		}
//	}
//	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	//to verify cart page is displaying or not
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
//	//verify the product in the cart page
//	System.out.println("hi");
	String product = driver.findElement(By.xpath("//*[@text='Air Jordan 9 Retro']")).getText();
	Assert.assertEquals(product, "Air Jordan 9 Retro");
}
}