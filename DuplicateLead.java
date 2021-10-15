package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		obj.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		obj.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("jdbathu@pec.edu");
		obj.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		String text = obj.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).getText();
		System.out.println(text);
		obj.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		obj.findElement(By.xpath("//a[contains(text(),'Duplicate Lead')]")).click();
		String title = obj.getTitle();
		System.out.println(title);
		if (title.contains("Duplicate Lead | opentaps CRM")) {
			obj.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		}
		String text2 = obj.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		if (text.contains(text2)) {
			System.out.println("duplicated lead name is same as captured name");
			
		}
		
		obj.close();
	}

}
