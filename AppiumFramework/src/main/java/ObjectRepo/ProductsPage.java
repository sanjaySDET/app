package ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.GestureUtility;
import io.appium.java_client.AppiumDriver;

public class ProductsPage {
	@FindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> productNames;
	
	@FindBy(id = "com.androidsample.generalstore:id/productAddCart")private WebElement addToCart;
	@FindBy(xpath = "//*[@text='ADD TO CART']")private List<WebElement> addToCartLink;
	
	@FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")private WebElement cartBtn;
	
	
	public ProductsPage(AppiumDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public List<WebElement> getProductCount() {
		return productNames;
	}


	public WebElement getAddToCart() {
		return addToCart;
	}


	public List<WebElement> getAddToCartLink() {
		return addToCartLink;
	}


	public WebElement getCartBtn() {
		return cartBtn;
	}
	
	
	public void addProductToCart(GestureUtility gLib,String itemName)
	{
		gLib.scrollingGestureToPerticularElement(itemName);
		//get the product names in the page
	    for(int i=0;i<productNames.size();i++)
	    {
	    	String productName = productNames.get(i).getText();
	    	if(productName.equalsIgnoreCase(itemName));
	    	{
	    		addToCart.click();
	    	}
	    	cartBtn.click();
	    }
	}
}