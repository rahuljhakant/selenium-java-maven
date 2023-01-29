package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/features/test.feature"}, glue = {"stepDef"},
        plugin = {})

public class testRunner extends AbstractTestNGCucumberTests {

}
