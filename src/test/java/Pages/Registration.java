package Pages;

import Utility.Utility;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Registration {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "login")
    WebElement linkSignIn;
    @FindBy(id = "email_create")
    WebElement textEmail;
    @FindBy(id = "SubmitCreate")
    WebElement buttonCreateAnAccount;
    @FindBy(id = "passwd")
    WebElement textPassword;
    @FindBy(id = "customer_firstname")
    WebElement textFirstName;
    @FindBy(id = "customer_lastname")
    WebElement textLastName;
    @FindBy(id = "address1")
    WebElement textAddress;
    @FindBy(id = "city")
    WebElement textCity;
    @FindBy(id = "id_state")
    WebElement optionState;
    @FindBy(id = "postcode")
    WebElement numberPostcode;
    @FindBy(id = "phone_mobile")
    WebElement numberPhone;
    @FindBy(id = "submitAccount")
    WebElement submitRegister;
    @FindBy(xpath = "//a[@class='logout']")
    WebElement signOut;

    public Registration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void doRegistration() throws InterruptedException, IOException, ParseException {
        Faker faker = new Faker();
        Utility utility = new Utility(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
        linkSignIn.click();

        String firstName = faker.name().firstName();
        String email= firstName.toLowerCase()+"@mailinator.com";
        String password = "P@ssword123";
        utility.writeInJSON(email,password);
        String phone = "0150"+(int)(Math.random() * (9999999 - 1000000 + 1) + 1000000);
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        textEmail.sendKeys(email);
        Thread.sleep(1000);
        buttonCreateAnAccount.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
        textFirstName.sendKeys(firstName);
        textLastName.sendKeys(faker.name().lastName());
        textPassword.sendKeys(password);
        textAddress.sendKeys(faker.address().streetAddress());
        textCity.sendKeys(faker.address().cityName());
        Thread.sleep(2000);
        Select state = new Select(optionState);
        state.selectByValue("2");
        Thread.sleep(1000);
        numberPostcode.sendKeys("56987");
        numberPhone.sendKeys(phone);
        submitRegister.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));
        signOut.click();
    }
}
