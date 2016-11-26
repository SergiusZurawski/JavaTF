/**
 * Created by Serg on 11/26/2016.
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String [] args){
        System.out.println(1);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "resources/phantomjs.exe");
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "resources/MicrosoftWebDriver.exe");
        System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
        //WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
        //WebDriver driver = new InternetExplorerDriver();
        WebDriver driver = new PhantomJSDriver(caps);
        driver.get("http://google.com");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File("screenshots/screenshot.png"));
        } catch (IOException e){System.out.println(e);}
    }
}
