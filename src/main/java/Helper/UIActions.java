package Helper;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIActions {
	
	protected WebDriver browser;
	WebDriverWait wait;

	public UIActions(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);
		wait = new WebDriverWait(browser, 30, 3000);
	}
	
	String message = "element not found";
	
	public JavascriptExecutor scriptExecutor() {
		return (JavascriptExecutor)browser;
	}

	public void scrollToView(WebElement element) {
		scriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public String  getTitle() {
		return browser.getTitle();
	}

	public void click(WebElement element) {
		try {
			waitForElementToAppear(element);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void type(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForUrlToChange() {
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(browser.getCurrentUrl())));
	}
	
	public void wiatUntilNestedLoctorVisible(WebElement parentElement, By childLocator) {
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parentElement, childLocator));
	}

	public String getCookieValue(String cookieName) {
		return browser.manage().getCookieNamed(cookieName).getValue();
	}

	public void waitForElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean isDisplayed(WebElement element) {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDisplayed;
	}

	public boolean isTextPresentOnPage(String text) {
		return browser.getPageSource().contains(text);
	}

	public String getText(WebElement element) {
		String text = "";
		try {
			waitForElementToAppear(element);
			text = element.getText();
		} catch (Exception e) {
			fail(message + "" + element);
		}

		return text;
	}

	
	public void jsSetAttribute(WebElement element, String text) {
		scriptExecutor().executeScript("arguments[0].setAttribute(arguments[1],arguments[2]);", element,"value", text);
	}
	
	public void switchToFrameAndType(WebElement iFrame, WebElement inputField, String text) {
		swithToFrame(iFrame);
		type(inputField, text);
		browser.switchTo().defaultContent();
	}
	
	public void swithToFrame(WebElement iFrame) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
	}
	
	public String getTextFromInput(WebElement element) {
		String value ="";
		try {
			value = element.getAttribute("value");
		} catch (Exception e) {
			fail(message+" "+ element);
		}
		return value;
	}

	public void selectByValue(WebElement element, String textValue) {
		try {
			Select select = new Select(element);
			select.selectByValue(textValue);
		} catch (Exception e) {
			fail(message + "" + element);
		}
	}
	
	public void typeAsCharArrays(WebElement element, String text) {
		waitForElementToAppear(element);
		  for(char ch:text.toCharArray()) {
			  element.sendKeys(Character.toString(ch));
	        }
	}

}
