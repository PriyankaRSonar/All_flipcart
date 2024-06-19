package Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Number_of_Links_on_Page 
{
	WebDriver driver;
	public Number_of_Links_on_Page(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void getLinkCount(){
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links on a Home page :: "+allLink.size());
		
	}
	
	
	public void getAllLinkInfo(){
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		
		for(WebElement link:allLink){
			System.out.println("Link Text :: "+ link.getText());
			System.out.println("Link URL  :: "+ link.getAttribute("href"));
			
			System.out.println("-------------------------------------------");
		}
	}
}
