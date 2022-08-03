package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class P04_SearchPage extends PageBase{
    public P04_SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;

    @FindBy(css = "button.button-1.search-box-button")
    public WebElement searchBtn;

    @FindBy(id = "ui-id-1")
   public List<WebElement> productList;
    @FindBy (xpath = "//div[@class=\"buttons\"]//button[@class=\"button-2 add-to-compare-list-button\"]")
    public List<WebElement> ComparetBtn;

    // @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
    @FindBy(css = "div.product-name")
    public WebElement productName;

    public void productSearch(String productName){

        sendTextElementText(searchTxtBox,productName);
        clickButton(searchBtn);

    }
    public void productSearchUsingAutoSuggest(String searchTxt){
        sendTextElementText(searchTxtBox,searchTxt);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productList.get(0).click();
    }
    public void AddProductToCompareList() {
        clickButton(ComparetBtn.get(0));

    }}
