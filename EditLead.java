package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		obj.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("jd");
		obj.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		String title = obj.getTitle();
		System.out.println(title);
		if (title.contains("View Lead | opentaps CRM")) {
			obj.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
			obj.findElement(By.id("updateLeadForm_companyName")).sendKeys("-edited");
			obj.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
			
		}
			
		obj.close();
		}

	}


