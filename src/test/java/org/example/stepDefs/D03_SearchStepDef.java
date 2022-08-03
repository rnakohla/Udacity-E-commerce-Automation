package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_SearchPage;
import org.example.pages.P05_ProductDetailsPage;
import org.testng.Assert;

public class D03_SearchStepDef {

    P04_SearchPage searchPageObject;
    P05_ProductDetailsPage productDetailsPageObject;

    @Given("user search on product using {string}")
    public void userSearchOnProductUsing(String SKU) {
        searchPageObject=new P04_SearchPage(Hooks.driver);
        searchPageObject.productSearch(SKU);


    }

    @When("Product search results displayed successfully ")
    public void userClicksOnSearchButton() {
        Assert.assertTrue(searchPageObject.productList.size()>0);
    }

    @Then("search results displayed successfully")
    public void searchResultsDisplayedSuccessfully() {
        productDetailsPageObject=new P05_ProductDetailsPage(Hooks.driver);
        Assert.assertTrue(searchPageObject.productName.getText().equalsIgnoreCase("Universal 7-8 Inch Tablet Cover"));
    }


}
