package GenericUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtility {

	AndroidDriver driver;
	public GestureUtility(AndroidDriver driver)
	{
		this.driver=driver;
	}
	/**
	 * To long press on the element
	 * @param driver
	 * @param element
	 * @param longPressDuration
	 */
	public void longPressGesture(WebElement element,long longPressDuration)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//search for appium gestures in chrome browser
		js.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),"duration",longPressDuration));	
	}
	
	/**
	 * scroll till the perticular element
	 * @param driver
	 * @param text
	 */
	public void scrollingGestureToPerticularElement(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}
	
	/**
	 * scroll till bottom of the page
	 * @param driver
	 */
	public void scrollTillBottomOfThePage()
	{
		boolean canScrollMore;
		do
		{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
	}while(canScrollMore);
	}
	
	/**
	 * this method used to swipe based on direction and co-ordinates
	 * @param driver
	 * @param element
	 * @param direction
	 */
	public void swipeLeft(WebElement element,String direction,double position)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), 
				"direction", ""+direction+"", 
				"percent", position));//0.75
	}
	/**
	 * This method is used to drag the source element and drop in perticular co-ordinates
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void dragAndDrop(WebElement element,int x,int y)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
    		    "elementId", ((RemoteWebElement) element).getId(),
    		    "endX",x,//629//you can get co-ordinates (click on swipe by co-ordinated) from inspector window
    		    "endY",y//555
    		));
	}
	/**
	 * this method will zoom the particular element
	 * @param element
	 * @param zoomSize
	 */
	public void pinchOpenGesture(WebElement element,double zoomInSize)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", zoomInSize //0.75
			));
	}
	/**
	 * this method will zoom-out the particular element
	 * @param element
	 * @param zoomOutSize
	 */
	public void pinchClosureGesture(WebElement element,double zoomOutSize)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", zoomOutSize //0.75
			));
	}
}
