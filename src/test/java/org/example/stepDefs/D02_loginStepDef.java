package org.example.stepDefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_RegistrationPage;
import org.example.pages.P02_HomePage;
import org.example.pages.P03_LoginPage;
import org.testng.Assert;

public class D02_loginStepDef {
    P02_HomePage homeObject;
    P01_RegistrationPage registrationPageObject;

    P03_LoginPage loginPageObject;

    String password="1234567";

    String email ="test12a@gmail.com";



    @Given("registered user with {string} and {string} logout to go to login page")
    public void registeredUserWithAndLogoutToGoToLoginPage(String email, String password) {

        homeObject=new P02_HomePage(Hooks.driver);
        homeObject.openRegistrationPage();

        registrationPageObject=new P01_RegistrationPage(Hooks.driver);
        registrationPageObject.userRegistration("rana", "Kohla", email, password);
        Hooks.driver.navigate().refresh();
        registrationPageObject.userLogout();
        homeObject.openLoginPage();

    }


    @When("user login with valid {string} and {string}")
    public void userLoginWithValidAnd(String email, String password) {
        loginPageObject=new P03_LoginPage(Hooks.driver);

        loginPageObject.userLogin(email,password);
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        Assert.assertTrue(loginPageObject.myAccountBtn.getText().contains("My account"));
    }

    @Given("user go to login page")
    public void userGoToLoginPage() {
       homeObject=new P02_HomePage(Hooks.driver);
       homeObject.openLoginPage();
    }


    @When("user login with invalid {string} and {string}")
    public void userLoginWithAnd(String email, String password) {
        loginPageObject=new P03_LoginPage(Hooks.driver);
        loginPageObject.userLogin(email,password);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        Assert.assertTrue(loginPageObject.UnsuccessMessage.getText().contains("unsuccessful"));
    }


}
