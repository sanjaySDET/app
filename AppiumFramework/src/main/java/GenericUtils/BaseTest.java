package GenericUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public GestureUtility gLib;
	@BeforeClass
	public void configAppium() throws MalformedURLException
	{
	    File file = new File("C:\\Users\\SanjayBabu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
	
	
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("vivo 1921");
		options.setAppPackage("com.androidsample.generalstore");
		options.setAppActivity(".SplashActivity");
		
		
	//	dc.setCapability("appPackage", "com.androidsample.generalstore");
	//	dc.setCapability("appActivity", ".SplashActivity");
		
	//	dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
	//	dc.setCapability("appActivity", ".TouchScreenTestActivity");

		
	//	dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
	//	dc.setCapability("appActivity", ".MainActivity");
		
	//	dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
	//	dc.setCapability("appActivity", ".TouchScreenTestActivity");
		
		
		URL url = new URL("http://localhost:4723");
		driver = new AndroidDriver(url, options);
		gLib=new GestureUtility(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
}
