package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P02_HomePage;
import org.testng.Assert;

public class D07_CategoryAndSubCategoryStepDef {
    P02_HomePage homeObject ;

    @Given("Open list of main category and select sub category")
    public void openListOfMainCategoryAndSelectSubCategory() {
        homeObject = new P02_HomePage(Hooks.driver);
        homeObject.selectElectronicssMenu();
    }

    @Then("page of selected sub category open successfully")
    public void pageOfSelectedSubCategoryOpenSuccessfully() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("electronics"));

    }
}
