package testsuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PositiveLogin {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://kasirdemo.belajarqa.com/");
    }

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin@email.com", "adminadmin");
        loginPage.assertSuccessLogin();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
