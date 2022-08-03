package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P012_CompareListPage extends PageBase{
    public P012_CompareListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "product comparison")
    public WebElement compareListMessage;

    public void openCompareList()
    {
        clickButton(compareListMessage);
    }
}
