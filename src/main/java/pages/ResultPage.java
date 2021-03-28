package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import Helper.UIActions;

import java.util.List;

public class ResultPage extends UIActions {

    @FindBy(css = ".newKeywordEntry button")
    WebElement priorities;

    @FindBy(css = ".keywordInput>form>input")
    WebElement filterbyprioritybox;

    @FindBy(css = ".keyword")
    WebElement addkeyword;
    
    @FindBy(css="#propertySearch-results-container")
    private WebElement searchResultsContainer;
    
    @FindBy(css= "[data-test*=propertyCard]")
    private List<WebElement> propertyCards;
    
    public ResultPage(WebDriver browser) {
		super(browser);
	}

	public void prioritiesProperty(String text) throws InterruptedException {
        click(priorities);
        type(filterbyprioritybox,text);
        Actions actions = new Actions(browser);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void searchResultByPriority() throws InterruptedException {
        for (int i = 0; i < propertyCards.size(); i++) {
        	List<WebElement> cards = propertyCards.get(i).findElements(By.cssSelector("[data-test=keyword-tag]"));
        	if(cards.size()>0) {
        		WebElement cardHeader = propertyCards.get(i).findElement(By.cssSelector(".propertyCard-details"));
            	click(cardHeader);
            	break;
        	}	
        }
    }
    
    public boolean searchResultsContainer() {
    	return isDisplayed(searchResultsContainer);
    }
}




