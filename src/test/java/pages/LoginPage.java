package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    By usernameField = By.id("email");
    By passwordField = By.id("password");
    By loginButton = By.xpath("(//button[@class='chakra-button css-1n8i4of'])");
    By kasirajaTitle = By.xpath("(//h3[@class='chakra-heading css-1wswht5'])");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password){
        this.inputUsername(username);
        this.inputPassword(password);
        this.clickLoginButton();
    }

    public void assertSuccessLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(kasirajaTitle));
        Assert.assertEquals(driver.findElement(kasirajaTitle).getText(),"kasirAja");
    }
}
