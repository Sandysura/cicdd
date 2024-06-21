package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="Features",glue="Rahulshettyacademy.Stepdefinition",
monochrome=true,tags="@Regression",plugin={"html:target/cucmber.html"})
public class TestRunner extends AbstractTestNGCucumberTests
{

}
