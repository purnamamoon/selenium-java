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
    }

    @Test
    public void addNewKategori(){
        String nama = "New Kategori";
        String deskripsi = "This is new kategori";
        categoriesPage = new CategoriesPage(driver);
        dashboardPage = new DashboardPage(driver);

        categoriesPage.addNewKategori(nama, deskripsi);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        categoriesPage.assertSuccessAddKategori(nama, deskripsi);
    }

    @Test
    public void deleteKategori(){
        categoriesPage = new CategoriesPage(driver);

        String nama = categoriesPage.getFirstItemKategoriName();
        String deskripsi = categoriesPage.getFirstItemKategoriDeskripsi();
        categoriesPage.clickMeatballsButton();
        categoriesPage.clickHapusButton();
        categoriesPage.clickConfirmDeleteButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        categoriesPage.asserSuccessDeleteKategori(nama, deskripsi);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
