package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Helper.UIActions;


public class FilterPage extends UIActions {

	@FindBy(id = "submit")
	WebElement findbutton;

	@FindBy(xpath = ".//*[@id='radius']")
	WebElement radius;

	@FindBy(xpath = ".//*[@id='minPrice']")
	WebElement minprice;

	@FindBy(xpath = ".//*[@id='maxPrice']")
	WebElement maxprice;

	@FindBy(xpath = ".//*[@id='minBedrooms']")
	WebElement minbed;

	@FindBy(xpath = ".//*[@id='maxBedrooms']")
	WebElement maxbed;

	@FindBy(xpath = ".//*[@id='displayPropertyType']")
	WebElement propertytype;

	@FindBy(xpath = ".//*[@id='maxDaysSinceAdded']")
	WebElement daysold;

	@FindBy(css = ".checkboxes.clearfix.touchsearch-searchcontrol-segment.touchsearch-searchcriteria-inputset>label")
	WebElement STCcheckbox;

	public FilterPage(WebDriver browser) {
		super(browser);
	}

	public void findpropertybutton() {
		click(findbutton);
	}

	public void filterRadius(String value) {
		click(radius);
		selectByValue(radius, value);
	}

	public void filterprice(String minPrice, String maxPrice) {
		click(minprice);
		selectByValue(minprice, minPrice);

		click(maxprice);
		selectByValue(maxprice, maxPrice);
	}

	public void filterbeds(String minBed, String maxBed) {
		click(minbed);
		selectByValue(minbed, minBed);

		click(maxbed);
		selectByValue(maxbed, maxBed);
	}

	public void selectpropertytype(String propetyTypeText) {
		click(propertytype);
		selectByValue(propertytype, propetyTypeText);
	}

	public void proertyAddedTo(String text) {
		click(daysold);
		selectByValue(daysold, text);
	}

	public void stccheckbox() throws InterruptedException {
		click(STCcheckbox);

	}

}
