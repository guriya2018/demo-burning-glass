package com.demo.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        plugin = { "html:build/cucumber-html-report",
        		"json:build/cucumber.json", "junit:build/cucumber.xml", "pretty:build/cucumber-pretty.txt" },
        tags = "@currentTest",
        glue={"com.demo.steps"},
        monochrome = true
        )

public class TestRunner {
	
//	gradle clean build testrun --continue generateCucumberReport

}
