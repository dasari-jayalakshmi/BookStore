package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/features"}, glue = "stepDefinitions", 
tags = "",dryRun = true, monochrome = true, plugin = {"json:target/cucumber.json"})

public class TestRun {

}

