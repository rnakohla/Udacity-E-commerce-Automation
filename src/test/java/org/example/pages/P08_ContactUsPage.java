package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P08_ContactUsPage extends PageBase{
    public P08_ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FriendEmail")
    WebElement emailFriendTxt;

    // @FindBy(id = "YourEmailAddress")

    @FindBy(id = "PersonalMessage")
    WebElement personalMessageTxt;


    @FindBy(css = "button.button-1.send-email-a-friend-button")
    WebElement submitMailBtn;

    @FindBy(css = "div.result")
    public WebElement messageNotification;

    public void sendEmailToFriend(String friendMail,String pesonalMessage){
        sendTextElementText(emailFriendTxt,friendMail);
        sendTextElementText(personalMessageTxt,pesonalMessage);
        clickButton(submitMailBtn);
    }
}
