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
  
   public  Browser(){
       PageFactory.initElements(driver,this);
   }

	private WebDriver initialise() {
		
		System.out.println("Running Test on Browser:" + determindBrowser());
		setDriverPath(determindBrowser());
        switch (determindBrowser()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
            	driver = new FirefoxDriver();
                break;
            default: 
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
		if (System.getProperty("os.name").contains("mac")) {
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
