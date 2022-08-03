package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P012_CompareListPage;
import org.example.pages.P04_SearchPage;
import org.example.pages.P05_ProductDetailsPage;
import org.testng.Assert;

public class D09_CompareListStepDef {
    P04_SearchPage searchObject;
    P05_ProductDetailsPage DetailsPage;
    P012_CompareListPage compareObject;
    P05_ProductDetailsPage productDetails;

    @When("Buttons of AddToComapreList appear successfully on searchlist")
    public void Buttons_OfAddToCompareList_Appear(){
        searchObject= new P04_SearchPage(Hooks.driver);
        Assert.assertTrue(searchObject.ComparetBtn.size()>0);
        System.out.println(searchObject.ComparetBtn.size());

    }
    @And("click on button AddToComapreList of first product")
    public void AddProductsToCompareList_FromSearchResult() throws InterruptedException {
        searchObject.AddProductToCompareList();

    }

    @Then("selected product is added to compare list successfully")
    public void Product_Added_To_CompareList_Successfully() throws InterruptedException {
        compareObject= new P012_CompareListPage(Hooks.driver);
        Thread.sleep(2000);
        Assert.assertTrue(compareObject.compareListMessage.isDisplayed());

    }

    @And("add current product to compare list from details page")
    public void Add_Product_ToCompareList_FromDetailsPgae()
    {
        DetailsPage= new P05_ProductDetailsPage(Hooks.driver);
        DetailsPage.AddProductToCompare();
    }


    @And("open details page of a product")
    public void openDetailsPageOfAProduct() {
        productDetails = new P05_ProductDetailsPage(Hooks.driver);
        Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains("MacBook"));
    }

    @Given("Search by {string}")
    public void searchBy(String arg0) {
        searchObject = new P04_SearchPage(Hooks.driver);
        searchObject.productSearchUsingAutoSuggest("Laptop");
    }
}

