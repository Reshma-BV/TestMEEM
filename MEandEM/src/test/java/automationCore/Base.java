package automationCore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public WebDriver driver;

	@BeforeMethod
	public void initializeBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://staging.meandem.vercel.app/palazzo-pant-black");
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
