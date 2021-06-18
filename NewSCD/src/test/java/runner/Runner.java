package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions
	(
	features="C:/Users/manoj.mali/git/repository2/NewSCD/src/test/java/feature/NewSCDLoginFeature.feature",
	glue= {"stepdefinition"},
		plugin={"pretty", "html:target/cucumber-reports/cucumberhtml.html", "json:target/cucumber-reports/CucumberTestReport.json",
				"junit:target/cucumber-reports/Cucumberjunit.xml"},
	//plugin = ("json:target/cucumber-reports/CucumberTestReport.json"),
				tags="@Smoketest1 or @Smoketest5 or @Smoketest10",	
	//tags="@Smoketest1 or @Smoketest5 or  @Smoketest8 or @Smoketest9 or @Smoketest10",
			publish = true,
			//tags="@Smoketest1 or @Smoketest2 or @Smoketest6", 
				//tags="@Smoketest1 or @Smoketest2 or @Smoketest7", 
			//@Smoketest2 or @Smoketest3 or @Smoketest4 or @Smoketest5
	monochrome = true
			)
		
	public class Runner {

}
