package testsScripts;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SignInTest {

	//@Test
	public void login() {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().refresh();

		driver.get("https://demo.guru99.com/V1/index.php");

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr652418");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("UhEbYnE");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		driver.quit();

	}

	@Test
	public void loginInEdge() throws Exception {

		WebDriver driver;
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless=new");

		URL hubUrl = new URI("http://10.0.0.73:4444/wd/hub").toURL();

		driver = new RemoteWebDriver(hubUrl, options);
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr652418");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("UhEbYnE");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		System.out.println("page title: " + driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void loginInChrome() throws Exception {

		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		URL hubUrl = new URI("http://10.0.0.73:4444/wd/hub").toURL();

		driver = new RemoteWebDriver(hubUrl, options);
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr652418");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("UhEbYnE");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		System.out.println("page title: " + driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void loginInFirefox() throws Exception {

		WebDriver driver;
		FirefoxOptions options = new FirefoxOptions(); 
		options.addArguments("--headless=new"); 

		URL hubUrl = new URI("http://10.0.0.73:4444/wd/hub").toURL(); 

		driver = new RemoteWebDriver(hubUrl, options); 
		driver.get("https://demo.guru99.com/V1/index.php"); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr652418"); 
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("UhEbYnE"); 
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click(); 
		System.out.println("page title: " + driver.getTitle()); 
		driver.quit();
	}

}
