package week2.day2;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[1]")).click();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[3]")).click();
		String attribute = driver.findElement(By.xpath("//a[contains(text(),'Find where am supposed to go wi')]"))
				.getAttribute("href");
		System.out.println(attribute);
		driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]")).click();
		if (driver.getPageSource().contains("HTTP Status 404 – Not Found")) {
			System.out.println("URL is broken");
		} else {
			
			System.out.println("URL is not broken");
		}
		driver.navigate().back();
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[2]")).click();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[3]")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		

	}
}
