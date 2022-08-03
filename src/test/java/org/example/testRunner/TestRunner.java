package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.stepDefs.Hooks;

@CucumberOptions(features = "src/main/resources/Features",
        glue = {"org.example.stepDefs"},
        plugin ={"pretty","html:target/cucumber=html-report",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        tags = "@smoke")
public class TestRunner extends AbstractTestNGCucumberTests{

}
