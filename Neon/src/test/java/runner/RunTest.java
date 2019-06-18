package runner;

import org.junit.Test;
import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



/**
 * @author CHIRAG
 *
 */

// Uncomment @RunWith if you are using Junit to run Test 
@RunWith(Cucumber.class)


@CucumberOptions(features={"src//test//java//features"}
					,glue={"steps","utility"}
					,plugin = {"pretty", "html:target/cucumber"}
					, tags ={"@Cliente"}
		)

public class RunTest 
{
	
}

