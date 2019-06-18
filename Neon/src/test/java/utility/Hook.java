package utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class Hook {

	private static AndroidDriver<?> driver;
	

	@Before
	public void setUpAppium() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("UDID", "711KPMZ0701043");
		cap.setCapability("deviceName", "Pixel 2 xl");
		cap.setCapability("noReset", true);
		cap.setCapability("resetKeyboard", true);
		
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\resources\\Cadastro_de_Clientesold.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	public static AndroidDriver<?> getDriver()
	{
		return driver;
	}
}
