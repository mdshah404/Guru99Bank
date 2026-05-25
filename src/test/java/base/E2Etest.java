package base;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Allure;

public class E2Etest {
	
	@Test
	public void chromeTest() throws Exception {
		
		Allure.step("chrome test started");
		
		Playwright playwright = Playwright.create();
		BrowserType chrom = playwright.chromium();
		Browser browser = chrom.launch(new BrowserType.LaunchOptions().setChannel("chrome").setArgs(Arrays.asList("--start-maximized")).setHeadless(false));
		//Browser browser = chrom.connect("ws://127.0.0.1:3000/");
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null).setRecordVideoDir(Paths.get("videos/")));
		
		context.tracing().start(new Tracing.StartOptions().setSnapshots(true).setScreenshots(true));
		
		Page page = context.newPage();
		
		page.navigate("https://demo.guru99.com/V4/index.php");
		
		page.locator("input[name=\"uid\"]").fill("mngr661200");
		
	    page.locator("input[name=\"password\"]").fill("vubYsaz");
	    
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
	    
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("New Customer")).click();
	    
	    page.locator("input[name=\"name\"]").fill("Tom Jason");
	    
	    //click female radio then male
	    page.getByRole(AriaRole.RADIO).nth(1).check();
	    
	    page.getByRole(AriaRole.RADIO).first().check();
	    
	    page.locator("#dob").fill("8595-02-04");
	    
	    page.locator("textarea[name=\"addr\"]").fill("23344 Main Lane");
	    
	    page.locator("input[name=\"city\"]").fill("Tobbier");
	    
	    page.locator("input[name=\"state\"]").fill("Hunaier");
	    
	    page.locator("input[name=\"pinno\"]").fill("234556");
	    
	    page.locator("input[name=\"telephoneno\"]").fill("3737379587596");
	    
	    page.locator("input[name=\"emailid\"]").fill("abcv@yahoo.com");
	    
	    page.locator("input[name=\"password\"]").fill("admin123");
	    
	    page.locator("input[name=\"emailid\"]").click();
	    
	    page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("abcv@yahoo.com").setExact(true)).click();
	    
	    page.locator("input[name=\"password\"]").fill("admin1234");
	    
	    //attach trace to allure report
        Path tracePath = Paths.get("tracings/trace.zip");
		context.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
		Allure.attachment("trace file", "This is trace.");
        try (InputStream is = Files.newInputStream(tracePath)) {
            Allure.attachment("trace", is);
        }
        
      //attach screenshot to allure report
	    Path screenshotPath = Paths.get("screenshots/signupPage.png");
	    byte[] screenPics = page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(screenshotPath));
	    String base64 = Base64.getEncoder().encodeToString(screenPics); 
	    
	    Allure.attachment("screenshot", "Signup page screenshot");
        try (InputStream is = Files.newInputStream(screenshotPath)) {
            Allure.attachment("image.png", is);
        }
		
        //Path videoPath = page.video().path();
		
		//page.close();
		context.close();
		browser.close();
		
		 //attach video to allure report
		Path videoPath = page.video().path();
	    Allure.attachment("execution video", "video/webm");
        try (InputStream is = Files.newInputStream(videoPath)) {
            Allure.attachment("video", is);
        }
        System.out.println("chrome test passed");
		Allure.step("chrome test finished");
	
	}

}
