package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    By dashboardMenu = By.xpath("(//a[@href='/dashboard'])[1]");
    By kategoriMenu = By.xpath("(//a[@href='/categories'])[1]");
    By produkMenu = By.xpath("(//a[@href='/products'])[1]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDashboardMenu(){
        driver.findElement(dashboardMenu).click();
    }

    public void clickKategoriMenu(){
        driver.findElement(kategoriMenu).click();
    }

    public void clickProdukMenu(){
        driver.findElement(produkMenu).click();
    }
}
