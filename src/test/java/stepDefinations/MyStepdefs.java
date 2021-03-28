package stepDefinations;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;



public class MyStepdefs extends BaseTest {
	
    @Before
    public void startup(){
    	initializePage();     
    }
    
    @After
    public void teardown(){
        browser.quit();
    }

    @Given("^I am home page$")
    public void iAmHomePage() throws Throwable {
        String actual = homePage.title();
        String expectedtitle = "Rightmove - UK's number one property website for properties for sale and to rent";
        Assert.assertEquals(actual, expectedtitle);
    }

    @When("^I enter location \"([^\"]*)\" on home page$")
    public void iEnterLocationOnHomePage(String location) throws Throwable {
    	homePage.search(location);
    }

    @And("^I click on \"([^\"]*)\" button on home page$")
    public void iClickOnButtonOnHomePage(String arg0) throws Throwable {
    	homePage.clickForSaleButton();
    }

    @Then("^I should navigate to find property for sale page$")
    public void iShouldNavigateToFindPropertyForSalePage() throws Throwable {
        boolean title = homePage.title().contains("Find property for sale in");
        Assert.assertTrue(title);
    }

    @When("^I select radius as \"([^\"]*)\" on filter page$")
    public void iSelectRadiusAsOnFilterPage(String arg0) throws Throwable {
        filterPage.filterRadius(arg0);
    }

    @And("^I select min price as \"([^\"]*)\" and max price as \"([^\"]*)\" on filter page$")
    public void iSelectMinPriceAsAndMaxPriceAsOnFilterPage(String arg1, String arg2) throws Throwable {
    	filterPage.filterprice(arg1, arg2);
    }

    @And("^I select no of bed rooms as min bed \"([^\"]*)\" and max bed \"([^\"]*)\" on filter page$")
    public void iSelectNoOfBedRoomsAsMinBedAndMaxBedOnFilterPage(String arg0, String arg1) throws Throwable {
    	filterPage.filterbeds(arg0, arg1);
    }

    @And("^I select property type as \"([^\"]*)\" on filter page$")
    public void iSelectPropertyTypeAsOnFilterPage(String arg0) throws Throwable {
    	filterPage.selectpropertytype(arg0);
    }

    @And("^I select added to site as \"([^\"]*)\" on filter page$")
    public void iSelectAddedToSiteAsOnFilterPage(String arg0) throws Throwable {
    	filterPage.proertyAddedTo(arg0);
    }

    @And("^I click on underoffer,soldor STC on filter page$")
    public void iClickOnUnderofferSoldorSTCOnFilterPage() throws Throwable {
    	filterPage.stccheckbox();
    }
    
    @When("I click on find property button on find property for sale on filter page")
    public void i_click_on_find_property_button_on_find_property_for_sale_on_filter_page() {
    	filterPage.findpropertybutton();
    }

    @Then("^I should navigate to property result page$")
    public void iShouldNavigateToPropertyResultPage() throws Throwable {
    	Assert.assertTrue(resultPage.searchResultsContainer());
    }

    @Then("^I should navigate to property result\"([^\"]*)\" page$")
    public void iShouldNavigateToPropertyResultPage(String arg0) throws Throwable {
        boolean title = browser.getTitle().contains("For Sale");
        Assert.assertTrue(title);
    }

    @When("^I filter \"([^\"]*)\" properties on result page$")
    public void iFilterPropertiesOnResultPage(String arg0) throws Throwable {
        resultPage.prioritiesProperty(arg0);
    }

    @Then("^I should see properties filtered by priority on result page$")
    public void iShouldSeePropertiesFilteredByPriorityOnResultPage() throws Throwable {
    	resultPage.searchResultByPriority();
    }


}
