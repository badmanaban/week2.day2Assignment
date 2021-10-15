package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver obj = new ChromeDriver();
		obj.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		obj.manage().window().maximize();
		obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		obj.findElement(By.name("UserFirstName")).sendKeys("jd");
		obj.findElement(By.name("UserLastName")).sendKeys("Bathu");
		obj.findElement(By.name("UserEmail")).sendKeys("jdbathu@pec.edu");
		obj.findElement(By.name("CompanyName")).sendKeys("DotGo");
		obj.findElement(By.name("UserPhone")).sendKeys("919751093613");
		obj.findElement(By.name("CompanyName")).sendKeys("DotGo");
		
		WebElement job = obj.findElement(By.name("UserTitle"));
		Select dropdown = new Select(job);
		dropdown.selectByVisibleText("Developer / Software Engineer / Analyst");
		
		WebElement employees = obj.findElement(By.name("CompanyEmployees"));
		Select dropdown2 = new Select(employees);
		dropdown2.selectByVisibleText("15 - 100 employees");
		
		WebElement country = obj.findElement(By.name("CompanyCountry"));
		Select dropdown3 = new Select(country);
		dropdown3.selectByVisibleText("United States");
		
		WebElement state = obj.findElement(By.name("CompanyState"));
		Select dropdown4 = new Select(state);
		dropdown4.selectByVisibleText("California");		
		
		
		obj.findElement(By.className("checkbox-ui")).click();
		Thread.sleep(2000);
		obj.close();
		
	}

}
