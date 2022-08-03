package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P01_RegistrationPage extends PageBase{

    public P01_RegistrationPage(WebDriver driver) {
        super(driver);

    }
    @FindBy(id = "gender")
    WebElement genderRadioBtn;

    @FindBy (id = "FirstName")
    WebElement fnTxtBox;

    @FindBy(id = "LastName")
    WebElement lnTxtBox;

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement pwConfirmTxtBox;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(className = "result")
    public WebElement successMessage;

    @FindBy(linkText = "Log out")
    public WebElement logoutBtn;

    public void userRegistration(String firstname ,String lastname ,String email ,String passwrod) {

        //genderRadioBtn.click();
        clickButton(genderRadioBtn);
        sendTextElementText(fnTxtBox,firstname);
        //fnTxtBox.sendKeys(firstname);
        //lnTxtBox.sendKeys(lastname);
        sendTextElementText(lnTxtBox,lastname);
        //emailTxtBox.sendKeys(email);
        sendTextElementText(emailTxtBox,email);
        //passwordTxtBox.sendKeys(passwrod);
        sendTextElementText(passwordTxtBox,passwrod);
        //pwConfirmTxtBox.sendKeys(passwrod);
        sendTextElementText(pwConfirmTxtBox,passwrod);
        //registerBtn.click();
        clickButton(registerBtn);

    }

    public void userLogout(){
        clickButton(logoutBtn);
    }


}
