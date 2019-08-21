package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/featureFiles" ,
 glue= {"QAAKALETests/SanityTestRemoteVerificationCucumber/src/test/java/seleniumTests"}
 )

public class runnerTest {


}
