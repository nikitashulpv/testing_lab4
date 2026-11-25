import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumCDSTest extends SeleniumTest {
    private final String URL_CDS = "https://m.cdsvyatka.com/";

    @Test
    public void scenario1_getRoute() {
        driver.get(URL_CDS);
        takeScreenshot("T3_S1_1_Открыт_сайт");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement citySelect = driver.findElement(By.id("id_CitySelect"));
        Select city = new Select(citySelect);
        city.selectByVisibleText("Киров");

        WebElement marshSelect = driver.findElement(By.id("id_MarshSelect"));
        Select march = new Select(marshSelect);
        march.selectByVisibleText("Тролл Т8: ул. Московская- проспект Строителей");

        WebElement takeMapBtn = driver.findElement(By.id("id_buttonMap"));
        takeMapBtn.click();

        takeScreenshot("T3_S1_2_Открыта_карта");

        List<WebElement> markers = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("canvas.leaflet-canvas-icon")));

        Assert.assertFalse("На карте не найдено ни одного автобуса", markers.isEmpty());

        WebElement firstBusMarker = markers.get(0);
        firstBusMarker.click();

        WebElement busInfoPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".leaflet-popup-content")
        ));

        String busInfo = busInfoPopup.getText();
        takeScreenshot("T3_S1_3_Характеристики_автобуса");

        Assert.assertTrue("Характеристики не содержат нужных данных", busInfo.contains("Т8"));
    }

    @Test
    public void scenario2_getPredict() {
        driver.get(URL_CDS);
        takeScreenshot("T3_S2_1_Открыт_сайт");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement citySelect = driver.findElement(By.id("id_CitySelect"));
        Select city = new Select(citySelect);
        city.selectByVisibleText("Киров");

        WebElement marshSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_MarshSelect")));
        Select march = new Select(marshSelect);
        march.selectByVisibleText("Тролл Т8: ул. Московская- проспект Строителей");

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("id_StopSelect"), "Мечта"
        ));

        WebElement StopSelect = driver.findElement(By.id("id_StopSelect"));
        Select stop = new Select(StopSelect);
        stop.selectByVisibleText("Мечта (код 907)");

        takeScreenshot("T3_S2_2_Выбраны_город_маршрут_остановка");

        WebElement takeMapBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_buttonPrediction")));
        takeMapBtn.click();

        WebElement numberBus = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(), 'Т8')]")
        ));
        String busInfo = numberBus.getText();

        WebElement time = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("td.minutes")
        ));
        String timeInfo = time.getText();

        takeScreenshot("T3_S2_3_Получен_прогноз");

        Assert.assertTrue("Характеристики не содержат нужных данных", busInfo.contains("Т8"));
        Assert.assertTrue("Время ожидания не содержит цифр", timeInfo.matches(".*\\d+.*"));
    }
}
