package BrowserTests;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class sample{

	public static void main(String[] args) throws MalformedURLException {
//		DesiredCapabilities dc=new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 1921");
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//	//	dc.setCapability(MobileCapabilityType.UDID, "f6861ca6");
//		dc.setCapability("appPackage", "com.androidsample.generalstore");
//		dc.setCapability("appActivity", ".SplashActivity");
//		
//		URL url = new URL("http://localhost:4723");
//		AndroidDriver driver = new AndroidDriver(url, dc);
//		
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	UiAutomator2Options options = new UiAutomator2Options();
	options.setPlatformName("Android");
	options.setDeviceName("vivo 1921");
	//options.setAutomationName("uiautomator2");
	options.setAppPackage("com.androidsample.generalstore");
	options.setAppActivity(".SplashActivity");
	
	URL url = new URL("http://localhost:4723");
	AndroidDriver driver = new AndroidDriver(url, options);
	}
}