package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radio {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("yes")).click();
		boolean unselected = driver.findElement(By.xpath("(//input[@value=0])[2]")).isSelected();
		if (unselected) {
			System.out.println("the button is selected");

		}
		boolean selected = driver.findElement(By.xpath("(//input[@value=1])[2]")).isSelected();
		if (selected) {
			System.out.println("The Checked radio button is selected by default");
		}
		boolean selected2 = driver.findElement(By.xpath("(//input[@value=1])[3]")).isSelected();
	if (selected2) {
		System.out.println("Age is already selected");
	}
	else
	{
	driver.findElement(By.xpath("(//input[@value=1])[3]")).click();
	}
	}

}
