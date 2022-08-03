package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P03_LoginPage extends PageBase{
    public P03_LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(linkText = "Log in")
    WebElement loginBtn;

    @FindBy(linkText = "My account")
    public WebElement myAccountBtn;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")
    public WebElement UnsuccessMessage;

    public void userLogin(String Email ,String Password ){
        sendTextElementText(emailTxtBox,Email);
        sendTextElementText(passwordTxtBox,Password);
        clickButton(loginBtn);


    }
    public void openMyAccount(){
        clickButton(myAccountBtn);
    }
}


