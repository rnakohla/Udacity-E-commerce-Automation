package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P05_ProductDetailsPage extends PageBase{
    public P05_ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/ul/li[4]/strong")
    public WebElement productTitle;

    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailFriendBtn;
    @FindBy(id = "price-value-4")
    public WebElement productPriceLbl;
    @FindBy(id="add-to-wishlist-button-4")
    WebElement addToWishlistBtn ;

    @FindBy(linkText="Add your review")
    WebElement addReviewLink;

    @FindBy(css="input.button-2.add-to-compare-list-button")
    WebElement addToCompareBtn ;

    @FindBy(id="add-to-cart-button-4")
    WebElement addToCartBtn ;

    @FindBy(css="strong.current-item")
    public WebElement productNamebreadCrumb;

    public void openEmailFriend(){
        clickButton(emailFriendBtn);
    }

    public void openAddReviewPage()
    {
        clickButton(addReviewLink);
    }

    public void AddProductToWishlist()
    {
        clickButton(addToWishlistBtn);
    }

    public void AddProductToCompare()
    {
        clickButton(addToCompareBtn);
    }

    public void AddToCart()
    {
        clickButton(addToCartBtn);
    }
}
