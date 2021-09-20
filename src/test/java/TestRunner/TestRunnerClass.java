package TestRunner;


import Utilities.PropertiesFileReader;
///import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
/////imports testNGCucumberRunner;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;


@CucumberOptions(
        features = "./features",
        glue = {"Stepdefs"},
        tags = {"@Test1"},
        ////////plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"},
        ////plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)

public class TestRunnerClass {
    private TestNGCucumberRunner testNGCucumberRunner;
    PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception{
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
///////all the feature files within the feature folder are passed as parameter
    ///to this @Test
    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature){
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    ///////////this 'features' method -->> finds all the feature files present in features folder and feeds the @Test
    @DataProvider
    public Object[][] features(){
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
      public void tearDownClass() throws Exception{
        testNGCucumberRunner.finish();
    }

//    @AfterClass
//    public void writeExtentReport() {
//        ////Reporter.
//        Reporter.loadXMLConfig(new File(propertiesFileReader.getReportConfigPath()));
//    }




}
