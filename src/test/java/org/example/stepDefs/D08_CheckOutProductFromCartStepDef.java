package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.testng.Assert;

public class D08_CheckOutProductFromCartStepDef {
    P04_SearchPage searchObject;
    P02_HomePage homeObject;
    P05_ProductDetailsPage productDetails;
    P09_ShoppingCartPage cartObject;
    P10_CheckoutPage checkoutObject;
    P11_OrderDetailsPage orderObject;

    @Given("user search on product {string}")
    public void userSearchOnProduct(String arg0) {
        searchObject = new P04_SearchPage(Hooks.driver);
        searchObject.productSearchUsingAutoSuggest("MacB");

    }

    @When("Search results appear successfully")
    public void searchResultsAppearSuccessfully() {
        productDetails = new P05_ProductDetailsPage(Hooks.driver);
        Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains("MacBook"));
    }

    @And("user add this product to Shopping cart")
    public void userAddThisProductToShoppingCart() throws InterruptedException {
        cartObject = new P09_ShoppingCartPage(Hooks.driver);
        productDetails.AddToCart();
        Thread.sleep(2000);
        Hooks.driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
        cartObject = new P09_ShoppingCartPage(Hooks.driver);
        Assert.assertTrue(cartObject.totalLbl.getText().contains("3,600"));
    }

    @And("user Can Checkout Products")
    public void userCanCheckoutProducts() throws InterruptedException {
        checkoutObject = new P10_CheckoutPage(Hooks.driver);
        cartObject.openCheckoutPageAsGuest();
        checkoutObject.CheckoutProduct("test", "user", "Egypt"
                , "testuser1@test.com", "test address", "123456", "32445566677", "Cairo", "Apple MacBook Pro 13-inch");
        Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
        Assert.assertTrue(checkoutObject.prodcutName.getText().contains("MacB"));
        checkoutObject.confirmOrder();
        Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
    }

    @Then("user Can View Order Details")
    public void userCanViewOrderDetails() throws InterruptedException {
        orderObject = new P11_OrderDetailsPage(Hooks.driver);
        checkoutObject.viewOrderDetails();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("orderdetails"));
        orderObject.DownloadPDFInvoice();
        Thread.sleep(3000);
        orderObject.PrintOrderDetails();
    }

}
