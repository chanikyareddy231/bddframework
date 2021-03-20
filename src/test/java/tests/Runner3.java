package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features={"@target/realtestfailedres.txt"},
			glue= {"gluecode"},
			tags="@retest",
			monochrome=true,
			plugin= {"pretty","html:target/retestres","rerun:target/retestfailedres.txt"}
		)

public class Runner3 extends AbstractTestNGCucumberTests
{
}
