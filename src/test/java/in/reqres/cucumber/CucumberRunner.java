package in.reqres.cucumber;


import cucumber.api.CucumberOptions;
import in.reqres.studentapp.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/")    //add last slash /)

public class CucumberRunner extends TestBase {

}
