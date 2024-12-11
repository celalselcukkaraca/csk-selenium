package page;

import configuration.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.SeleniumUtils;

@Getter
public class BeyogluPage extends BasePage{
    WebDriver driver = Driver.getDriver();
    SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
    public String baseUrl = "https://www.turkiye.gov.tr/beyoglu-belediyesi-arsa-rayic";
    public By beyogluLogo = By.xpath("//img[@class='agencyLogo webp']");
    public By neighborhood = By.id("mahalle");
    public By street = By.id("caddesokak");
    public By year = By.id("yil");
    public By submitButton = By.xpath("//input[@class='submitButton']");
    public By table = By.xpath("//input[@class='resultTable striped']");
    public By tableHeaderNeighborHood = By.cssSelector("tr > th:nth-of-type(1)");
    public By tableHeaderStreet = By.cssSelector("tr > th:nth-of-type(2)");
    public By tableHeaderYear = By.cssSelector("tr > th:nth-of-type(3)");
    public By tableHeaderFairValue = By.cssSelector("tr > th:nth-of-type(4)");
    public By tableBodyNeighborHood = By.cssSelector("tr > td:nth-of-type(1)");
    public By tableBodyStreet = By.cssSelector("tr > td:nth-of-type(2)");
    public By tableBodyYear = By.cssSelector("tr > td:nth-of-type(3)");
    public By tableBodyFairValue = By.cssSelector("tr > td:nth-of-type(4)");

    public void goToBeyogluPage() {
        seleniumUtils.goToUrl(baseUrl);
        seleniumUtils.waitForVisibility(beyogluLogo);
        Assert.assertTrue(seleniumUtils.isVisible(beyogluLogo));
    }

    public void fillInputs(String neighborhoodName, String streetName, String yearValue) {

        seleniumUtils.selectDropDownByText(neighborhood, neighborhoodName);
        seleniumUtils.selectDropDownByText(street, streetName);
        seleniumUtils.selectDropDownByText(year, yearValue);
        seleniumUtils.click(submitButton);
    }

    public void checkResultTable(String neighborhoodName, String streetName, String yearValue) {
        Assert.assertEquals(seleniumUtils.getElementText(tableHeaderNeighborHood),"Mahalle Adı");
        Assert.assertEquals(seleniumUtils.getElementText(tableHeaderStreet),"Cadde/Sokak Adı");
        Assert.assertEquals(seleniumUtils.getElementText(tableHeaderYear),"Yıl");
        Assert.assertEquals(seleniumUtils.getElementText(tableHeaderFairValue),"Rayiç Değeri (TL)");
        Assert.assertEquals(seleniumUtils.getElementText(tableBodyNeighborHood),neighborhoodName);
        Assert.assertEquals(seleniumUtils.getElementText(tableBodyStreet),streetName);
        Assert.assertEquals(seleniumUtils.getElementText(tableBodyYear),yearValue);
    }
}