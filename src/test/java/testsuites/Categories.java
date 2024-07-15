package testsuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.Random;

public class Categories {
    WebDriver driver;
    CategoriesPage categoriesPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://kasirdemo.belajarqa.com/");

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        loginPage.login("admin@email.com","adminadmin");
        loginPage.assertSuccessLogin();
        dashboardPage.clickKategoriMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void addNewKategori() {
        Random rand = new Random();
        Integer randomNumber = rand.nextInt(9999);
        String nama = "New Kategori " + randomNumber;
        String deskripsi = "This is new kategori " + randomNumber;
        categoriesPage = new CategoriesPage(driver);
        dashboardPage = new DashboardPage(driver);

        categoriesPage.addNewKategori(nama, deskripsi);
        categoriesPage.assertSuccessToastIsVisible();
        driver.navigate().refresh();
        categoriesPage.assertSuccessAddKategori(nama, deskripsi);
    }

    @Test
    public void deleteKategori() {
        categoriesPage = new CategoriesPage(driver);
        String nama = categoriesPage.getFirstItemKategoriName();
        String deskripsi = categoriesPage.getFirstItemKategoriDeskripsi();

        categoriesPage.clickMeatballsButton();
        categoriesPage.clickHapusButton();
        categoriesPage.clickConfirmDeleteButton();
        categoriesPage.asserSuccessDeleteKategori(nama, deskripsi);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
