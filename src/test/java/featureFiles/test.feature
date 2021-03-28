Feature: verify the filter works to search the properties
  As a user I should filter the search result
  so that I can see non-featured property

  Scenario Outline: filter first non-featured property
    Given I am home page
    When  I enter location "<location>" on home page
    And   I click on "For Sale" button on home page
    Then  I should navigate to find property for sale page
    When  I select radius as "<radius>" on filter page
    And   I select min price as "<min>" and max price as "<max>" on filter page
    And   I select no of bed rooms as min bed "<minbed>" and max bed "<maxbed>" on filter page
    And   I select property type as "<propertytype>" on filter page
    And   I select added to site as "<addedtosite>" on filter page
    And   I click on underoffer,soldor STC on filter page
    And   I click on find property button on find property for sale on filter page
    Then  I should navigate to property result"<propertytype>" page
    When  I filter "<priority>" properties on result page
    Then  I should see properties filtered by priority on result page

    Examples:
      | location          	| radius | min   | max    | minbed | maxbed | propertytype | addedtosite | priority    |
      | Wembley, Middle 	| 1.0    | 50000 | 500000 | 3      | 3    	| houses       | 7           | non-featured|