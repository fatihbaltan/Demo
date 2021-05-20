package com.devapi.currencycloud.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com/devapi/currencycloud/step_definitions",
        dryRun = true,
        tags = "@wip"
)

public class CukesRunner {
}
