package page;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import configuration.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.SeleniumUtils;

import java.util.List;

@Getter
public class PharmacyPage extends BasePage {
    WebDriver driver = Driver.getDriver();
    SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
    public String baseUrl = "https://www.turkiye.gov.tr/saglik-titck-nobetci-eczane-sorgulama";
    public By healthMinisterLogo = By.xpath("//img[@class='agencyLogo webp']");
    public By city = By.id("plakaKodu");
    public By district = By.xpath("//select[contains(@aria-controls,'searchTable')]");
    public By date = By.id("nobetTarihi");
    public By map = By.id("mapid");
    public By submitButton = By.xpath("//input[@class='submitButton']");
    public By filteredDistrict = By.xpath("//tr[@data-row-filtered='0']");


    public void goToPharmacyPage() {
        seleniumUtils.goToUrl(baseUrl);
        seleniumUtils.waitForVisibility(healthMinisterLogo);
        Assert.assertTrue(seleniumUtils.isVisible(healthMinisterLogo));
    }

    public void fillInputs(String cityValue, String dateValue) {

        seleniumUtils.selectDropDownByText(city, cityValue);
        seleniumUtils.sendKeys(date, dateValue);
        seleniumUtils.click(submitButton);
    }

    public void selectDistrict(String districtValue) {
        seleniumUtils.selectDropDownByText(district, districtValue);
    }

    public void checkTableIsFiltered(String districtValue) {

        List<WebElement> filteredRows = driver.findElements(filteredDistrict);

        for (WebElement row : filteredRows) {
            WebElement district = row.findElement(By.xpath(".//td[@data-cell-order='1']"));

            Assert.assertEquals(district.getText(), districtValue);
        }
    }

    public void clickShowOnTheMapButton() {
        List<WebElement> filteredRows = driver.findElements(filteredDistrict);
        filteredRows.get(0).findElement(By.xpath(".//td[@data-cell-order='4']")).click();
    }

    public void checkMapIsDisplayed() {
        seleniumUtils.waitForVisibility(map);
        Assert.assertTrue(seleniumUtils.isVisible(map));
    }
}