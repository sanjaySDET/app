package DriverMethods;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import GenericUtils.BaseTest;
import io.appium.java_client.TouchAction;

/**
 * https://appium.github.io/java-client/io/appium/java_client/android/AndroidDriver.html
 * https://codoid.com/mobile-application-testing/appium-commands/
 * https://www.javatpoint.com/appium
 * @author SanjayBabu
 *
 */
public class ExtraMethods extends BaseTest{
	@Test
	
	public void extraMethods() throws MalformedURLException, InterruptedException
	{
//		DesiredCapabilities dc=new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 1921");
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//		
//		URL url = new URL("http://localhost:4723");
//		AndroidDriver driver = new AndroidDriver(url, dc);
/*		//To run check application is installed or not
		System.out.println(driver.isAppInstalled("io.appium.android.apis"));
		
		//To run application in background
		driver.runAppInBackground(Duration.ofSeconds(30));
		
		//To get the status of application
		System.out.println(driver.queryAppState("com.androidsample.generalstore"));
		
		//Installing App
        driver.installApp("apk file path");
        
       //verify app is installed or not
        System.out.println(driver.isAppInstalled("io.appium.android.apis"));
        
      //Screen Orientation in PORTRAIT mode 
      	ScreenOrientation s=driver.getOrientation();
      	driver.rotate(s.PORTRAIT);
      	
      //Screen Orientation in LANDSCAPE mode
      	ScreenOrientation s1=driver.getOrientation();
      	driver.rotate(s1.LANDSCAPE);
		
		//To open Notifications
		driver.openNotifications();
      	
		//To hide keyboard
		driver.hideKeyboard();
		
		//To check whether the device is locked
		System.out.println(driver.isDeviceLocked());
		
		//To will get which orientation of the phone
		System.out.println(driver.getOrientation());
		
		//It will lock the device*/
//		driver.lockDevice();
//		System.out.println(driver.getDisplayDensity());
//		System.out.println(driver.getSystemBars());
		
		//To get battery info
//		 AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();
//	      // Print battery status information
//	     System.out.println("Battery Level: " + batteryInfo.getLevel());
//	     System.out.println("Battery State: " + batteryInfo.getState());
	     
//		Performing key press action
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
//		driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_UP));
//		driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_DOWN));	
//		driver.pressKey(new KeyEvent(AndroidKey.Z));
	
//		driver.unlockDevice();
//		driver.lockDevice();
//		System.out.println(driver.isDeviceLocked());
		
		//get phone timings
//		System.out.println(driver.getDeviceTime());
		
		//To get device location
//		System.out.println(driver.location());
		
	//To check device orientation
//		System.out.println(driver.getOrientation());
		
		//change the orientation of the device to Landscape
//		driver.rotate(ScreenOrientation.LANDSCAPE);
//		Thread.sleep(3000);
//		//change the orientation of the device to Potrait
//		driver.rotate(ScreenOrientation.PORTRAIT);
		
	  //To close the current app
//		driver.terminateApp("io.appium.android.apis");
		
		// remove an App from the device
//		driver.removeApp("io.appium.android.apis");
		
		//To retrieve the full capabilities associated with the driver
//		System.out.println(driver.getCapabilities());
		
		
	}
}