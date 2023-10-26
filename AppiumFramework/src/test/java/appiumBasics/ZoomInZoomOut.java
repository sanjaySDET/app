package appiumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import GenericUtils.BaseTest;

public class ZoomInZoomOut extends BaseTest{
	
	@Test
	public void zoomInZoomOut() throws InterruptedException
	{
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		driver.findElement(By.xpath("//*[@text='View pager galleries']")).click();
		WebElement element = driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));
//		//Pinch - open gesture
//		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) element).getId(),
//			    "percent", 0.75
//			));
		
		gLib.pinchOpenGesture(element, 1);
		Thread.sleep(4000);
		//Pinch - close gesture
//		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) element).getId(),
//			    "percent", 0.75
//			));
		gLib.pinchClosureGesture(element, 1);
	}

}
