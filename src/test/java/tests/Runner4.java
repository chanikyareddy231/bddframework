package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features={"src\\test\\resources\\features"},
			glue= {"gluecode"},
			tags="@regressiontest",
			monochrome=true,
			plugin= {"pretty","html:target/regressiontestres","rerun:target/failedregressiontestscenarios.txt"}
		)

public class Runner4 extends AbstractTestNGCucumberTests
{
}
