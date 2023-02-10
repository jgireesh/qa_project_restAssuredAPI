package io.api.customers;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
        glue="io.api.customers",
        tags = "@GetCustomers",
        publish = true
)
public class TestRunner {
}
