package hooks;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	 WebDriver driver;
	 Properties p;
     
	@Before
    public void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("websiteURL"));
    	driver.manage().window().maximize();	
	}
	
    @After
    public void tearDown() {	
       driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	File sourcePath = ts.getScreenshotAs(OutputType.FILE);
            File destinationPath = new File("Screenshots/" + scenario.getName() + ".png");
            try {
                FileUtils.copyFile(sourcePath, destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
            }       
        }
    }
}
