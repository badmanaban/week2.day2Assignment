package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement findElement = driver.findElement(By.id("dropdown1"));
		Select dd1 = new Select(findElement);
		dd1.selectByIndex(0);
		
		WebElement findElement1 = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(findElement1);
		dd2.selectByVisibleText("Selenium");
		
		WebElement findElement2 = driver.findElement(By.name("dropdown3"));
		Select dd3 = new Select(findElement2);
		dd3.selectByValue("1");
		
		WebElement findElement3 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select dd4 = new Select(findElement3);
		int size = dd4.getOptions().size();
		System.out.println(size);
		
		driver.findElement(By.xpath("(//div[@class='example'])[5]//select")).sendKeys("Selenium");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//option[@value='1'])[6]")).click();
		
	}

}
