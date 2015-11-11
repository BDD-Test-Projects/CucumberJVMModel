package cucumber.xplore.java.tests;



import com.gargoylesoftware.htmlunit.BrowserVersion;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.fail;

    /**
    * Created by IntelliJ IDEA.
    * User: Vinod Kumar M
    * Date: 29/03/12
    * Time: 14:34
    * To change this template use File | Settings | File Templates.
    */
    public class SharedDriver extends WebDriverException {

    private static WebDriver driver;
    private static ChromeDriverService _chrome;
    private static DesiredCapabilities  _capabilities;
    public static String directory = System.getProperty("user.dir");
    private static String drivers = directory + File.separator + "src" + File.separator + "test"
            + File.separator+"resources"+File.separator+"drivers";


     @Before("~@noWebDriver")
     public static void setUp() throws Exception {

         String browser  =  System.getProperty("browser");
         String key = browser;

         System.out.println("The Browser used is: "+key);


         if (key.equalsIgnoreCase("chrome")){
             setChromeDriver();
         } else if (key.equalsIgnoreCase("firefox")){
             setFirefoxDriver();
         } else if(key.equalsIgnoreCase("safari")){
             setSafariDriver();
         } else {
             setInternetExplorerDriver();
         }
         
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }


    public static WebDriver getDriver() {


        if (driver == null) {
            throw new IllegalStateException("Selenium client is not initialised.");
        }
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }finally {
            return driver.switchTo().defaultContent();
        }

    }
    
    public static void setFirefoxDriver(){


        _capabilities = DesiredCapabilities.firefox();
        FirefoxProfile _profile = new FirefoxProfile();
        _profile.setPreference("network.http.phishy-userpass-length", 255);
        driver = new FirefoxDriver(_capabilities);

    }
        
    public static void setChromeDriver(){

        String OSIAmIn = System.getProperty("os.name").toLowerCase();
        System.out.println("The OS i am using is :"+OSIAmIn);
        if (OSIAmIn.contains("windows")){
            _chrome = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(drivers +File.separator+"win" + File.separator + "chromedriver.exe"))
                    .usingPort(9515)
                    .build();

            try {
                _chrome.start();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            _capabilities = DesiredCapabilities.chrome();
            _capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
            driver = new RemoteWebDriver(_chrome.getUrl(), _capabilities);


        /*}else if (OSIAmIn.contains("linux")){
            *//*_chrome = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(drivers +File.separator+"linux"))
                    .usingPort(9515)
                    .build();
            //.usingDriverExecutable(new File(drivers +File.separator+"linux" + File.separator + "chromedriver"))
        *//*
            HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
            driver.setJavascriptEnabled(true);*/


        }


        //ChromeOptions options = new ChromeOptions();



    }

    public static void setInternetExplorerDriver(){

        _capabilities = DesiredCapabilities.internetExplorer();
        _capabilities.setCapability("ignoreProtectedModeSettings", true);

        driver = new InternetExplorerDriver(_capabilities);
    }

    public static void setSafariDriver(){

        _capabilities = DesiredCapabilities.safari();
        driver = new SafariDriver(_capabilities);

    }


    @After
    public static void close(Scenario scenario)  {
        StringBuffer verificationErrors = new StringBuffer();

        System.out.println("hello, I'm running closeBrowser");
        if (driver != null) {
            if (_capabilities.getBrowserName().equalsIgnoreCase("chrome")){
               if (scenario.isFailed()){
                    driver = new Augmenter().augment(driver);
                    try {
                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");
                    } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                        System.out.println("the screenshot embed failed !!");
                        System.err.println(somePlatformsDontSupportScreenshots.getMessage());
                    }
                }
                _chrome.stop();

            } else {
                if (scenario.isFailed()){
                    try {
                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");
                    } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                        System.out.println("the screenshot embed failed !!");
                        System.err.println(somePlatformsDontSupportScreenshots.getMessage());
                    }
                }
            driver.quit();
            }

            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }
    }

    }


