package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_RegistrationPage;
import org.example.pages.P02_HomePage;
import org.example.pages.P03_LoginPage;
import org.example.pages.P06_MyAccountPage;
import org.testng.Assert;

public class D04_MyAccountStepDef {

    P02_HomePage homeObject;
    P01_RegistrationPage registrationPageObject;
    P06_MyAccountPage myAccountObject;
    P03_LoginPage loginPageObject;


    @Given("registered user with {string} and {string}")
    public void registeredUserWithAnd(String email, String oldPassword) {
        homeObject=new P02_HomePage(Hooks.driver);
        homeObject.openRegistrationPage();

        registrationPageObject=new P01_RegistrationPage(Hooks.driver);
        registrationPageObject.userRegistration("rana", "Kohla", email, oldPassword);
    }

    @When("user goes to my account page")
    public void userGoesToMyAccountPage() {
        myAccountObject=new P06_MyAccountPage(Hooks.driver);
        loginPageObject=new P03_LoginPage(Hooks.driver);
        loginPageObject.openMyAccount();

    }

    @And("user change his password by entering {string} and the {string}")
    public void userChangeHisPasswordByEnteringAndThe(String oldPassword, String newPassword) {
        myAccountObject=new P06_MyAccountPage(Hooks.driver);
        myAccountObject.openChangePassword();
        myAccountObject.changePassword(oldPassword,newPassword);
    }

    @Then("password changed successfully")
    public void passwordChangedSuccessfully() {
        Assert.assertTrue(myAccountObject.changePasswordResult.isDisplayed());

    }

}
