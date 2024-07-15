package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CategoriesPage {
    WebDriver driver;

    By tambahButton = By.xpath("(//a[@class='chakra-button css-1piskbq'])");
    By namaField = By.id("nama");
    By deskripsiField = By.id("deskripsi");
    By simpanButton = By.xpath("(//button[@class='chakra-button css-l5lnz6'])");
    By firstItemKategoriName = By.xpath("(//td[@class='css-u3dlpe'])[1]");
    By firstItemKategoriDeskripsi = By.xpath("(//td[@class='css-u3dlpe'])[2]");
    By meatballsButton = By.xpath("(//button[@class='chakra-button chakra-menu__menu-button css-pu8osu'])[1]");
    By hapusButton = By.xpath("(//button[@class='chakra-menu__menuitem css-13c7rae'])[1]");
    By ubahButton = By.xpath("(//a[@class='chakra-menu__menuitem css-13c7rae'])[1]");
    By successToast = By.xpath("(//div[@class='chakra-alert__title css-tidvy5'])[1]");
    By confirmDeleteButton = By.xpath("(//button[@class='chakra-button css-n45e6f'])");

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTambahButton(){
        driver.findElement(tambahButton).click();
    }

    public void clickSimpanButton(){
        driver.findElement(simpanButton).click();
    }

    public void clickMeatballsButton(){
        driver.findElement(meatballsButton).click();
    }

    public void clickUbahButton(){
        driver.findElement(ubahButton).click();
    }

    public void clickHapusButton(){
        driver.findElement(hapusButton).click();
    }

    public void clickConfirmDeleteButton(){
        driver.findElement(confirmDeleteButton).click();
    }

    public void inputNamaField(String nama){
        driver.findElement(namaField).sendKeys(nama);
    }

    public void inputDeskripsiField(String deskripsi){
        driver.findElement(deskripsiField).sendKeys(deskripsi);
    }

    public void addNewKategori(String nama, String deskripsi){
        this.clickTambahButton();
        this.inputNamaField(nama);
        this.inputDeskripsiField(deskripsi);
        this.clickSimpanButton();
    }

    public String getFirstItemKategoriName(){
        String nama = driver.findElement(firstItemKategoriName).getText();

        return nama;
    }

    public String getFirstItemKategoriDeskripsi(){
        String deskripsi = driver.findElement(firstItemKategoriDeskripsi).getText();

        return deskripsi;
    }

    public String getToastMessage(){
        String message = driver.findElement(successToast).getText();

        return message;
    }

    public void assertSuccessToastIsVisible(){
        String message = this.getToastMessage();
        driver.findElement(successToast).isDisplayed();
        Assert.assertEquals(message, "success");
    }

    public void assertSuccessAddKategori(String nama, String deskripsi){
        String firstKategoriName = this.getFirstItemKategoriName();
        String firstKategoriDeskripsi = this.getFirstItemKategoriDeskripsi();

        Assert.assertEquals(firstKategoriName,nama);
        Assert.assertEquals(firstKategoriDeskripsi,deskripsi);
    }

    public void asserSuccessDeleteKategori(String nama, String deskripsi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(firstItemKategoriName, nama)));

        String firstKategoriName = this.getFirstItemKategoriName();
        String firstKategoriDeskripsi = this.getFirstItemKategoriDeskripsi();
        Assert.assertNotEquals(firstKategoriName,nama);
        Assert.assertNotEquals(firstKategoriDeskripsi,deskripsi);
    }
}
