package testrunner;

import pages.Registration;
import setup.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTestRunner extends Setup {
    Registration registration;

    @Test
    public void userRegistration() throws IOException, ParseException, InterruptedException {
        registration = new Registration(driver);
        for (int i = 1; i <= 2; i++) {
            registration.doRegistration();
            Thread.sleep(2000);
        }
    }
}
