package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver obj = new ChromeDriver();
		obj.get("https://en-gb.facebook.com/");
		obj.manage().window().maximize();
		obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		obj.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		WebElement fn = obj.findElement(By.name("firstname"));
		fn.sendKeys("jd");
		obj.findElement(By.name("lastname")).sendKeys("Bathu");
		obj.findElement(By.name("reg_email__")).sendKeys("91123456789");
		obj.findElement(By.name("reg_passwd__")).sendKeys("Bathu@123");
		
		WebElement day = obj.findElement(By.name("birthday_day"));
		Select dropdown = new Select(day);
		dropdown.selectByIndex(4);
		
		WebElement month = obj.findElement(By.name("birthday_month"));
		Select dropdown2 = new Select(month);
		dropdown2.selectByIndex(8);
		
		WebElement yr = obj.findElement(By.name("birthday_year"));
		Select dropdown3 = new Select(yr);
		dropdown3.selectByVisibleText("1992");
		
		obj.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		
		
	}

}
