package generalStore;

import org.testng.annotations.Test;

import GenericUtils.BaseTest;
import ObjectRepo.LoginPage;

public class FirstScript extends BaseTest {

	@Test
	public void LoginToApp() 
	{
		//enter your name
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("sanjay");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getYourNameTxtFiled().sendKeys("sanjay");
		loginPage.loginToApp(driver, gLib,"Austria");
		
//		//enter female dropdown
//		driver.findElement(By.xpath("//*[@text='Female']")).click();
//		//select dropdown
//		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//		//scrolldown and click on text india
//		gLib.scrollingGestureToPerticularElement("Austria");
//		driver.findElement(By.xpath("//*[@text='Austria']")).click();
//		//click on lets shop button
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
}
