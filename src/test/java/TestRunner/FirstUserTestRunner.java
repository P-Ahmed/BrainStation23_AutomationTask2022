package TestRunner;

import Pages.Login;
import Pages.PurchaseItem;
import Setup.Setup;
import Utility.Utility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstUserTestRunner extends Setup {
    Login login;
    Utility utility;
    PurchaseItem purchaseItem;

    @Test
    public void firstUserTestCycle() throws InterruptedException, IOException, ParseException {
        login = new Login(driver);
        utility = new Utility(driver);
        purchaseItem = new PurchaseItem(driver);
        String email = utility.readEmailFromJSON(0);
        String password = utility.readPasswordFromJSON(0);

        driver.get("http://automationpractice.com/index.php");

        login.doLogin(email,password);

        purchaseItem.purchasingDresses();
        purchaseItem.purchasingTShirts();
        String successMessage = purchaseItem.checkingOut();
        Assert.assertEquals(successMessage, "Your order on My Store is complete.");
    }
}
