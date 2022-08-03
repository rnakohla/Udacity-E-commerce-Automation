package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P09_ShoppingCartPage extends PageBase{

        public P09_ShoppingCartPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(name = "removefromcart")
        WebElement removeCheck;

        @FindBy(name = "updatecart")
        WebElement updateCartBtn;

        @FindBy(css = "input.qty-input valid")
        public WebElement quantityTxt;

        @FindBy(css = "td.subtotal")
        public WebElement totalLbl;


        @FindBy(id="checkout")
        WebElement checkoutBtn ;

        @FindBy(id="termsofservice")
        WebElement agreeCheckbox;

        @FindBy(css="input.button-1.checkout-as-guest-button")
        WebElement guestCheckoutBtn ;

        public void RemoveProductFromCart() {
            clickButton(removeCheck);
            clickButton(updateCartBtn);
        }

        public void UpdateProductQuantityInCart(String quantity) {
            //clear quantity textbox
            clearText(quantityTxt);
            sendTextElementText(quantityTxt, quantity);
            clickButton(updateCartBtn);
        }

        public void openCheckoutPage()
        {
            clickButton(agreeCheckbox);
            clickButton(checkoutBtn);
        }

        public void openCheckoutPageAsGuest()
        {
            clickButton(agreeCheckbox);
            clickButton(checkoutBtn);
            clickButton(guestCheckoutBtn);
        }
    }





