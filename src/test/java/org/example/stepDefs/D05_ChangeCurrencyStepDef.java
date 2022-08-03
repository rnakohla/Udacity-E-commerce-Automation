package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_HomePage;
import org.example.pages.P04_SearchPage;
import org.example.pages.P05_ProductDetailsPage;
import org.testng.Assert;

public class D05_ChangeCurrencyStepDef {
    P05_ProductDetailsPage productDetailsPageObject;
    P04_SearchPage searchPageObject;
    P02_HomePage homeObject;


    @Given("user go to product  details page {string}")
    public void userGoToProductDetailsPage(String searchTxt) {

        searchPageObject=new P04_SearchPage(Hooks.driver);
        productDetailsPageObject=new P05_ProductDetailsPage(Hooks.driver);
        searchPageObject.productSearchUsingAutoSuggest(searchTxt);
    }

    @When("user change currency")
    public void userChangeCurrency() {
        homeObject=new P02_HomePage(Hooks.driver);
        productDetailsPageObject=new P05_ProductDetailsPage(Hooks.driver);
        homeObject.changeCurrency();

    }

    @Then("currency changed successfully")
    public void currencyChangedSuccessfully() {

        searchPageObject=new P04_SearchPage(Hooks.driver);
        productDetailsPageObject=new P05_ProductDetailsPage(Hooks.driver);
        searchPageObject.productSearchUsingAutoSuggest("Apple MacBook Pro 13");
        Assert.assertTrue(productDetailsPageObject.productTitle.getText().contains("Apple MacBook Pro 13"));
        Assert.assertTrue(productDetailsPageObject.productPriceLbl.getText().contains("€"));
    }
}
