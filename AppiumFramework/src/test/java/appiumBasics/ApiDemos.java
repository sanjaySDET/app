package appiumBasics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtils.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ApiDemos extends BaseTest{
	@Test
	public void wifiSettings() throws MalformedURLException, InterruptedException
	{
		//click on preference
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//click on preference dependencies
		driver.findElement(By.xpath("//*[@text='3. Preference dependencies']")).click();
		//click on wifi checkbox
		driver.findElement(By.id("android:id/checkbox")).click();
		//click on wifi settings
		driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
		//verify the popup
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		//enter wifi name 
		driver.findElement(By.className("android.widget.EditText")).sendKeys("secure");
		//click on ok 
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		Thread .sleep(3000);
	}
	
	@Test
	public void longPress() throws InterruptedException
	{
		//click on views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//click on Expandable lists
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		//custom Adapter
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		//long press on people names
		WebElement people = driver.findElement(By.xpath("//*[@text='People Names']"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		//search for appium gestures in chrome browser
//		js.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) people).getId(),"duration",2000));
		gLib.longPressGesture(people, 2000);
		//verify sample menu is displaying or not
		String ExpectedSampleMenu = driver.findElement(By.xpath("//*[@text='Sample menu']")).getText();
		Assert.assertEquals(ExpectedSampleMenu, "Sample menu");
		System.out.println("TestCase is pass");
	}
	
	@Test
	public void scrolling()
	{
		//click on views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//scroll to webView text (1 way)
	//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		gLib.scrollingGestureToPerticularElement("WebView");
		//scroll when u dont have no prior idea (2-way)//it will till the bottom of the page
		/*		boolean canScrollMore;
		do
		{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
	}while(canScrollMore);*/
		//gLib.scrollTillBottomOfThePage(driver);
	}
    @Test
	public void swipeing() throws InterruptedException
	{
    	//click on views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//click on gallery
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		//click on photos
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		//verify whether the focus is on 1st image
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
		//swipe to second image from 1st image
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		gLib.swipeLeft(firstImage, "left", 0.25);
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) firstImage).getId(),
//			    "direction", "left",
//			    "percent", 0.25
//			));
		//verify whether the focus is not on 1st image
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
		Thread.sleep(2000);
		
		//swipe right
		// verify whether the focus is on 2nd image
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("focusable"),"true");
		// swipe to second image from 1st image
		WebElement secondImage = driver.findElement(By.xpath("(//android.widget.ImageView)[2]"));
		gLib.swipeLeft(firstImage, "right", 0.75);
		//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
//				((RemoteWebElement) secondImage).getId(), 
//				"direction", "right", 
//				"percent", 0.75));
		// verify whether the focus is not on 2nd image
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("focusable"),
				"false");
	}
    @Test
    public void dragAndDrop()
    {
    	//click on views
    	driver.findElement(AppiumBy.accessibilityId("Views")).click();
    	//click on drag and drop
    	driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
    	
    	WebElement src = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
    	gLib.dragAndDrop(src, 629, 555);
//    	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//    		    "elementId", ((RemoteWebElement) src).getId(),
//    		    "endX", 629,//you can get co-ordinates (click on swipe by co-ordinated) from inspector window
//    		    "endY", 555
//    		));
    	String dropped = driver.findElement(By.xpath("//*[@text='Dropped!']")).getText();
    	Assert.assertEquals(dropped, "Dropped!");
    	System.out.println("test case is pass");
    }
    @Test
    public void landScapeOrientation() throws InterruptedException
    {
    	//click on preference
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//click on preference dependencies
		driver.findElement(By.xpath("//*[@text='3. Preference dependencies']")).click();
		//click on wifi checkbox
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//rotate the phone in landscape mode
		DeviceRotation landscape=new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		//click on wifi settings
		driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
		//verify the popup
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		// enter wifi name
		//you can do copy paste here by
		//copy to clipboard and paste it in clipboard
		driver.setClipboardText("secure");
		//paste
		driver.findElement(By.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
		
		//To perform key actions
		//to click on enter key
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//to click on back key
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//to click on home button
		Thread.sleep(2000);		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		// click on ok
		//driver.findElement(By.xpath("//*[@text='OK']")).click();
	}
  
	@Test
    public void appPackageAndActivity()
    {
//    	If you want to open particular page by skipping all the page , you need to give appackage and activity of particular page.
//
//    	To do that navigate to particular page
//    	Open cmd promt and type adb shell and click enter
//    	Type the cmd:--  dumpsys activity activities | grep mResumedActivity    (and hit enter)
//    	Activity act = new Activity("io.appium.android.apis", ".preference.PreferenceDependencies");
//    	driver.startActivity(act);
//    	// By skipping all the pages go to perticular wifi page
//		// click on wifi checkbox
//		driver.findElement(By.id("android:id/checkbox")).click();
//		// click on wifi settings
//		driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
//		// verify the popup
//		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
//		Assert.assertEquals(alertTitle, "WiFi settings");
//		// enter wifi name
//		driver.findElement(By.className("android.widget.EditText")).sendKeys("secure");
//		// click on ok
//		driver.findElement(By.xpath("//*[@text='OK']")).click();
    }
}
