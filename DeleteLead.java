package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver obj = new ChromeDriver();
		obj.manage().window().maximize();
		obj.get("http://leaftaps.com/opentaps/control/main");
		obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebElement username = obj.findElement(By.id("username"));
		username.sendKeys("Demosalesmanager");
		obj.findElement(By.id("password")).sendKeys("crmsfa");
		obj.findElement(By.className("decorativeSubmit")).click();
		obj.findElement(By.linkText("CRM/SFA")).click();
		obj.findElement(By.linkText("Leads")).click();
		obj.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		obj.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		obj.findElement(By.name("phoneCountryCode")).sendKeys("91");
		obj.findElement(By.name("phoneNumber")).sendKeys("9751093613");
		obj.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		String text = obj.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).getText();
		System.out.println(text);
		Thread.sleep(2000);
		
		obj.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		
		obj.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		obj.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		
		obj.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
		obj.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		String text2 = obj.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		if (text2.contains("No records to display")) {
			System.out.println("the record is deleted successfully");
		}
			else
			{
				System.out.println("The record is not deleted");
			}
			
		}
	}

