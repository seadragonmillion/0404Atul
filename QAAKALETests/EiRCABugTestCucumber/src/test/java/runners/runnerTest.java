package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/features" ,
 glue= {"seleniumTests"} ,
 tags= {"@ChromeTest"}
 )

public class runnerTest {


}
