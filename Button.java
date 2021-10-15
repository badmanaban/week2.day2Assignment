package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[contains(text(),'Go to Home Page')]")).click();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[2]")).click();
		Point location = driver.findElement(By.xpath("//button[contains(text(),'Get Position')]")).getLocation();
		System.out.println("the position is" + location);
		String cssValue = driver.findElement(By.xpath("//button[contains(text(),'What color am I?')]")).getCssValue("background-color");
		System.out.println("The color is" + cssValue);
		Dimension size = driver.findElement(By.xpath("//button[contains(text(),'What is my size?')]")).getSize();
		System.out.println("The size is" + size);

	}

}
