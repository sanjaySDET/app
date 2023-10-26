package generalStore;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtils.BaseTest;
import ObjectRepo.LoginPage;
/**
 * Dont enter username and click on letsShop btn
 */
public class VrifyTheToastMsgTest extends BaseTest{

	@Test
	public void toastMsg() {
		
		LoginPage loginPage = new LoginPage(driver);
		//don't enter your name 
		//loginPage.getYourNameTxtFiled().sendKeys("sanjay");
		loginPage.loginToApp(driver, gLib,"Austria");
		String toastMessage = loginPage.getToastMsg().getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		System.out.println("test case is pass");
		
		
//		// enter your name
//	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("sanjay");
//		// enter female dropdown
//		driver.findElement(By.xpath("//*[@text='Female']")).click();
//		// select dropdown
//		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//		// scrolldown and click on text india
//		gLib.scrollingGestureToPerticularElement(driver, "Austria");
//		driver.findElement(By.xpath("//*[@text='Austria']")).click();
//		// click on lets shop button
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		//To verify the Toast msg ->here index specifies toast msg 1->name attribute indicates values present in name attribute
//		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//		Assert.assertEquals(toastMessage, "Please enter your name");
	}
}
