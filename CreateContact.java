package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Contact')]")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("jd");
		driver.findElement(By.id("lastNameField")).sendKeys("bathu");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("j");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Badmanaban");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Testing");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("jdbathu@gmail.com");
		
		WebElement findElement = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select state = new Select(findElement);
		state.selectByVisibleText("New York");
		
		
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		driver.findElement(By.name("description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		System.out.println("The title is : " + driver.getTitle());

				
	}

}
