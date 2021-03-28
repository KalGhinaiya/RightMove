package stepDefinations;

import org.openqa.selenium.WebDriver;

import browserFactory.Browser;
import pages.FilterPage;
import pages.HomePage;
import pages.ResultPage;


public class BaseTest {
	
	WebDriver browser;
	Browser bro;
	HomePage homePage;
	FilterPage filterPage;
	ResultPage resultPage;
	
	public void initializePage() {
		
		Browser brows = new Browser();
		browser = brows.openBrowser();
		homePage = new HomePage(browser);
	    filterPage = new FilterPage(browser);
	    resultPage= new ResultPage(browser);
		
	}
	


}
