package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_SearchPage;
import org.example.pages.P05_ProductDetailsPage;
import org.example.pages.P09_ShoppingCartPage;
import org.testng.Assert;

public class D06_ShoppingCartStepDef {

    P04_SearchPage searchPage;
    P05_ProductDetailsPage productDetails;
    P09_ShoppingCartPage cartPage;

    @Given("user Search by {string}")
    public void userSearchBy(String arg0) {
        searchPage = new P04_SearchPage(Hooks.driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetails = new P05_ProductDetailsPage(Hooks.driver);

    }

    @When("Search result appear successfully")
    public void searchResultAppearSuccessfully() {
        Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains("MacB"));

    }

    @And("user add  product to Shopping cart")
    public void userAddProductToShoppingCart() throws InterruptedException {
        productDetails = new P05_ProductDetailsPage(Hooks.driver);
        productDetails.AddToCart();
        Thread.sleep(1000);
        Hooks.driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
    }

    @Then("selected product is added to shopping cart successfully")
    public void selectedProductIsAddedToShoppingCartSuccessfully() {
        cartPage = new P09_ShoppingCartPage(Hooks.driver);
        Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));

    }


    @Given("user Search again by {string}")
    public void userSearchAgainBy(String arg0) {
        searchPage = new P04_SearchPage(Hooks.driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetails = new P05_ProductDetailsPage(Hooks.driver);
    }

    @When("Search result appeared successfully")
    public void searchResultAppearedSuccessfully() {
        Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains("MacB"));
    }

    @And("Add first product to Shopping cart")
    public void addFirstProductToShoppingCart() throws InterruptedException {
        productDetails = new P05_ProductDetailsPage(Hooks.driver);
        productDetails.AddToCart();
        Thread.sleep(1000);
        Hooks.driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
    }

    @Then("Remove product from shopping cart")
    public void removeAllProductsFromShoppingCart() {
        cartPage = new P09_ShoppingCartPage(Hooks.driver);
        cartPage.RemoveProductFromCart();
    }
}
