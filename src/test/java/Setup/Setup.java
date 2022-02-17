package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Setup {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
