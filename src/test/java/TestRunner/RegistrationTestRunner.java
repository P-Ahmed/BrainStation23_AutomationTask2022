package TestRunner;

import Pages.Registration;
import Setup.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTestRunner extends Setup {
    Registration registration;

    @Test
    public void firstUserRegistration() throws InterruptedException, IOException, ParseException {
        registration = new Pages.Registration(driver);
        driver.get("http://automationpractice.com/index.php");

        registration.doRegistration();
        Thread.sleep(2000);
    }

    @Test
    public void secondUserRegistration() throws InterruptedException, IOException, ParseException {
        registration = new Pages.Registration(driver);
        driver.get("http://automationpractice.com/index.php");

        registration.doRegistration();
        Thread.sleep(2000);
    }
}
