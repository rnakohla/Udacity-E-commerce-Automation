package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P06_MyAccountPage extends PageBase{
    public P06_MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "OldPassword")
    WebElement oldPasswordBox;

    @FindBy(id = "NewPassword")
    WebElement newPasswordBox;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordBox;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
    WebElement changePasswordBtn;


    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div")
    public WebElement changePasswordResult;
    //@FindBy(linkText = "Password was changed")

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
    WebElement changePasswordLink;

    public void openChangePassword(){
        clickButton(changePasswordLink);
    }
    public void changePassword(String password,String newPassword) {
        sendTextElementText(oldPasswordBox, password);
        sendTextElementText(newPasswordBox, newPassword);
        sendTextElementText(confirmNewPasswordBox, newPassword);
        clickButton(changePasswordBtn);

    }
}
