package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.GestureUtility;
import io.appium.java_client.AppiumDriver;

public class LoginPage {

	@FindBy(id = "com.androidsample.generalstore:id/nameField")private WebElement yourNameTxtFiled;
	
	@FindBy(xpath = "//*[@text='Female']")private WebElement FemaleGenderBox;
	
	@FindBy(id = "com.androidsample.generalstore:id/spinnerCountry")private WebElement countryDropdown;
	
	@FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")private WebElement letsShopBtn;
	
	@FindBy(xpath = "(//android.widget.Toast)[1]")private WebElement toastMsg;
	
	public LoginPage(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getYourNameTxtFiled() {
		return yourNameTxtFiled;
	}


	public WebElement getFemaleGenderBox() {
		return FemaleGenderBox;
	}


	public WebElement getCountryDropdown() {
		return countryDropdown;
	}


	public WebElement getLetsShopBtn() {
		return letsShopBtn;
	}
	
	
	public WebElement getToastMsg() {
		return toastMsg;
	}


	public void loginToApp(AppiumDriver driver,GestureUtility gLib,String country)
	{
	//	yourNameTxtFiled.sendKeys(name);
		FemaleGenderBox.click();
		countryDropdown.click();
		gLib.scrollingGestureToPerticularElement(country);
		driver.findElement(By.xpath("//*[@text='"+country+"']")).click();
		letsShopBtn.click();
	}
}
