package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "login")
    WebElement linkSignIn;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "passwd")
    WebElement txtPassword;
    @FindBy(id = "SubmitLogin")
    WebElement btnSignIn;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String email, String password){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(linkSignIn));
        linkSignIn.click();
        wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSignIn.click();
    }
}
