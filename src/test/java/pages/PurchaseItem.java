package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PurchaseItem {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@title='Dresses']")
    List<WebElement> selectDress;
    @FindBy(xpath = "//a[@class='subcategory-name'][contains(text(),'Casual Dresses')]")
    WebElement selectCasualDress;
    @FindBy(xpath = "//a[@title='Printed Dress']")
    List<WebElement> selectPrintedDress;
    @FindBy(xpath = "//button[@name='Submit']")
    WebElement addToCart;
    @FindBy(xpath = "//span[@class='cross']")
    WebElement cross;
    @FindBy(xpath = "//a[@title='T-shirts']")
    List<WebElement> selectTShirtsMenu;
    @FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']")
    List<WebElement> selectingShirt;
    @FindBy(id = "color_14")
    WebElement selectingBlueFilter;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement toCheckout;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement summaryCheckout;
    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement addressCheckout;
    @FindBy(id = "cgv")
    WebElement checkBox;
    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement shippingCheckout;
    @FindBy(xpath = "//a[@class='cheque']")
    WebElement payByCheck;
    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement confirmOrder;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement orderConfirmation;


    public PurchaseItem(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void purchasingDresses() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(3000);
        selectDress.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectCasualDress));
        selectCasualDress.click();
        selectPrintedDress.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='cross']")));
        cross.click();
        Thread.sleep(3000);
    }
    public void purchasingTShirts() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        selectTShirtsMenu.get(1).click();
        Thread.sleep(2000);
        selectingShirt.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectingBlueFilter));
        selectingBlueFilter.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        Thread.sleep(3000);
    }

    public String checkingOut() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Thread.sleep(3000);
        toCheckout.click();
        wait.until(ExpectedConditions.elementToBeClickable(summaryCheckout));
        summaryCheckout.click();
        wait.until(ExpectedConditions.elementToBeClickable(addressCheckout));
        addressCheckout.click();
        Thread.sleep(2000);
        checkBox.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(shippingCheckout));
        shippingCheckout.click();
        wait.until(ExpectedConditions.elementToBeClickable(payByCheck));
        payByCheck.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
        confirmOrder.click();

        wait.until(ExpectedConditions.elementToBeClickable(orderConfirmation));
        String successMessage = orderConfirmation.getText();
        return successMessage;
    }

}
