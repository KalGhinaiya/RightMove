package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Helper.UIActions;
import java.util.List;

public class HomePage extends UIActions {

    @FindBy(css = "#buy")
    private WebElement searchbutton;
    
    @FindBy (css = "#searchLocation" )
    private WebElement searchLocationInput;
    
    @FindBy (css="#typeaheadList li")
    private List<WebElement>  searchResultsList;
    
    @FindBy(css = "li.typeAheadLocation")
    private WebElement locationDropdown;
    
    By childElement = By.tagName("a");
    


    public HomePage(WebDriver browser) {
		super(browser);
	}

	public String title() {
        return getTitle();
    }

    public void search(String text) throws InterruptedException {
    	typeAsCharArrays(searchLocationInput, text);
    
        for (WebElement searchResult : searchResultsList) {
            if (getText(searchResult).equalsIgnoreCase(text)) {
            	click(searchResult);
                break;
            }
        }
    }

    public void clickForSaleButton() {
        click(searchbutton);
    }


}
