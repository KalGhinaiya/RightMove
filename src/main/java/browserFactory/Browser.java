package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Browser {
	
	ResourceBundle rb = ResourceBundle.getBundle("config");
    private  WebDriver driver; 
    public WebDriver browser;
  
	private WebDriver initialise() {
		String browserType = determindBrowser();
		System.out.println("Running Test on Browser:" + browserType );
		setDriverPath(browserType);
		if (browserType.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public WebDriver openBrowser() {
		browser = initialise();
		browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
        browser.manage().deleteAllCookies();
        browser.get(rb.getString("domain"));
		return browser;	
	}
	
	public String  determindBrowser() {
		return (System.getProperty("browser") == null) ? rb.getString("browser") : System.getProperty("browser");
	}
	
	private void setDriverPath(String browserType) {
		if (System.getProperty("os.name").contains("Mac")) {
			if (browserType.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver","src/main/resources/binary/mac/chromedriver");
			} else {
				System.setProperty("webdriver.gecko.driver","src/main/resources/binary/mac/geckodriver");
			}
		} else {
			if (browserType.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver","src/main/resources/binary/windows/chromedriver.exe");
			} else {
				System.setProperty("webdriver.gecko.driver","src/main/resources/binary/windows/geckodriver.exe");
			}
		}
	}
	
	
}
