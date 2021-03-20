package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features={"src\\test\\resources\\features"},
			glue= {"gluecode"},
			tags="@realtest",
			monochrome=true,
			plugin= {"pretty","html:target/realtestres","rerun:target/realtestfailedres.txt"}
		)

public class Runner2 extends AbstractTestNGCucumberTests
{
}
