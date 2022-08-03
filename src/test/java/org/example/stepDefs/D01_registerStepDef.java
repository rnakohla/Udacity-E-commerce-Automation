package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_RegistrationPage;
import org.example.pages.P02_HomePage;
import org.example.pages.P03_LoginPage;
import org.testng.Assert;

public class D01_registerStepDef {

    P02_HomePage homeObject;
    P01_RegistrationPage registrationPageObject;

    P03_LoginPage loginPageObject;

    @Given("user go to register page")
    public void user_go_to_register_page() {
        homeObject=new P02_HomePage(Hooks.driver);
        homeObject.openRegistrationPage();
    }

    @When("user clicks on Registration Link")
    public void user_clicks_on_registration_link() {

        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("register"));
    }

    /*@And( "enters {firstname},{lastname},{email},{password}")
    public void enters_all_information(String firstname,String lastname,String email ,String password) {
        registrationPageObject=new P01_RegistrationPage(Hooks.driver);
        registrationPageObject.userRegistration(firstname, lastname, email,password);
    }*/

    @Then("the registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        Assert.assertTrue(registrationPageObject.successMessage.getText().contains("completed"));
    }



    @And("user enters {string},{string},{string},{string}")
    public void userEnters(String firstname,String lastname,String email ,String password) {
        registrationPageObject=new P01_RegistrationPage(Hooks.driver);
        registrationPageObject.userRegistration(firstname, lastname, email,password);
    }

}
