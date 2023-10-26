package BrowserTests;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericUtils.BrowserBaseTest;

public class Wikipedia extends BrowserBaseTest
{
	@Test
	public void wikipedia() throws InterruptedException, MalformedURLException
	{
		driver.get("https://www.wikipedia.org/");
		driver.findElement(By.cssSelector("#searchInput")).sendKeys("sanjay");
		List<WebElement> suggestions = driver.findElements(By.xpath("//h3[@class='suggestion-title']"));
		for (WebElement Element : suggestions) 
		{
			String text = Element.getText();
			if(text.contains(" Leela Bhansali"))
			{
			   Element.click();
			   break;
			}
		}
		Thread.sleep(5000);
	}
}