package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class P02_HomePage extends PageBase{

    public P02_HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Register")
    WebElement registrationLink ;


    @FindBy(linkText = "Log in")
    public WebElement loginBtn;

    @FindBy(id = "customerCurrency")
    WebElement currencyDropDown;

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Welcome to our store")
    public WebElement welcomeMessage;
    @FindBy(linkText="Computers")
    WebElement ComputerMenu;

    @FindBy(linkText="Electronics")
    WebElement ElectronicssMenu;

    public void openLoginPage(){
        clickButton(loginBtn);
    }


    public void openRegistrationPage() {
        clickButton(registrationLink);
    }

    public void openContactUsPage(){
        scrollToBottom();
        clickButton(contactUsLink);
    }

    public void changeCurrency(){
        select=new Select(currencyDropDown);
        select.selectByVisibleText("Euro");
    }
    public void selectElectronicssMenu()
    {
        action
                .moveToElement(ComputerMenu)
                .moveToElement(ElectronicssMenu)
                .click()
                .build()
                .perform();
    }

}
