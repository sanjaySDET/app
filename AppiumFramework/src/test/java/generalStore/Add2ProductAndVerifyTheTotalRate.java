package generalStore;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtils.BaseTest;
import ObjectRepo.LoginPage;
import ObjectRepo.ProductsPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Add2ProductAndVerifyTheTotalRate extends BaseTest{

	@Test
	public void add2ProductAndVerifyTheTotalRate() throws InterruptedException, MalformedURLException
	{	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getYourNameTxtFiled().sendKeys("sanjay");
		loginPage.loginToApp(driver, gLib,"Austria");
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.getAddToCartLink().get(0).click();
		productsPage.getAddToCartLink().get(0).click();
		productsPage.getCartBtn().click();
//		// enter your name
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("sanjay");
//		// enter female dropdown
//		driver.findElement(By.xpath("//*[@text='Female']")).click();
//		// select dropdown
//		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//		// scrolldown and click on text india
//		gLib.scrollingGestureToPerticularElement(driver, "Austria");
//		driver.findElement(By.xpath("//*[@text='Austria']")).click();
//		// click on lets shop button
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Add 1st 2 product to cart
		//adding 1st product by giving get(0)
//		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		//adding 2nd product by giving get(0)->because once after the adding 1st product 2nd product ll be get(0)
//		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		//click on add to cart
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//to verify cart page is displaying or not
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		//fetch the products price
		List<WebElement> prices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		double sum=0;
		for(int i=0;i<prices.size();i++)
		{
			String productsPrice = prices.get(i).getText();
			double Total2ProductPrice = Double.parseDouble(productsPrice.substring(1));//1 because in 0 $ is there,u r neglecting that
			sum = sum+Total2ProductPrice;
			System.out.println(sum);
		}
		String tPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double totalPrice = Double.parseDouble(tPrice.substring(1));
		Assert.assertEquals(sum, totalPrice);
		System.out.println("test case is pass");
		//next long press on please read terms and condition
		WebElement termsCondition = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		gLib.longPressGesture(termsCondition, 2000);
		//click on close btn in the popup
		driver.findElement(By.id("android:id/button1")).click();
		//click on send me mail checkbox
		driver.findElement(By.className("android.widget.CheckBox")).click();
		//click on visit To Wibsite btn
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		//once after clicking on proceed btn its opening in browser now u need to 
		//give ctrl to browser to automate ->to do that download driver.exe file and config in baseTest
		Thread.sleep(6000);
	//	(getContextHandles) this method will fetch what type of application
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) 
		{
			System.out.println(contextName);
			//NATIVE_APP
			//WEBVIEW_com.androidsample.generalstore
		}
		//now switching the ctrl to webview ->take control from selenium by using sdriver
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//to go back
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}