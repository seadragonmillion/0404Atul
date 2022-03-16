package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/features" ,
 glue= {"seleniumTests"} ,
 tags= {"@E0USAChromeTest"}
 )

public class runnerTest {


}
