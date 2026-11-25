import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumOtzovikTest extends SeleniumTest {
    private final String URL_OTZOVIK = "https://otzovik.com/";

    @Test
    public void scenario1_getYandexMetro() {
        driver.get(URL_OTZOVIK);
        takeScreenshot("T2_S1_1_Открыт_сайт");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchInput = driver.findElement(By.id("header-search-input"));
        searchInput.sendKeys("Yandex Metro - программа для Android");
        takeScreenshot("T2_S1_2_Введен_запрос");
        searchInput.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.titleContains("Yandex Metro"));

        String actualTitle = driver.getTitle();
        takeScreenshot("T2_S1_3_Открыт_нужная_страница");
        Assert.assertTrue("Не удалось перейти на страницу. Заголовок: " + actualTitle,
                actualTitle.contains("Yandex Metro - программа для Android"));

        WebElement reviews = driver.findElement(By.cssSelector("a.reviews-counter[href*='yandex_metro']"));
        String reviewsText = reviews.getText();

        Assert.assertTrue("Количество отзывов пустое",
                reviewsText.matches(".*\\d+.*"));
    }

    @Test
    public void scenario2_writeReview() {
        driver.get(URL_OTZOVIK);
        takeScreenshot("T2_S2_1_Открыт_сайт");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement writeReviewBtn = driver.findElement(By.cssSelector("a.header-postreview-btn"));
        writeReviewBtn.click();

        wait.until(ExpectedConditions.titleContains("Написать отзыв"));

        WebElement searchInput = driver.findElement(By.id("tproduct"));
        searchInput.sendKeys("Ботанический сад в Кирове");

        takeScreenshot("T2_S2_2_Введен_запрос");

        WebElement targetItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='popup-obj'][contains(., 'ВятГУ')]")
        ));
        targetItem.click();

        WebElement rating = driver.findElement(By.id("rating0"));
        Select ratingSelect = new Select(rating);
        ratingSelect.selectByVisibleText("5 - Отлично");

        WebElement overallImpression = driver.findElement(By.id("content_title"));
        overallImpression.sendKeys("123");

        WebElement textReview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea.text_area_auto_height_ta")
        ));
        textReview.click();
        textReview.sendKeys("Текст отзыва");

        WebElement procReview = driver.findElement(By.name("content_pros"));
        procReview.sendKeys("123");

        WebElement consReview = driver.findElement(By.name("content_cons"));
        consReview.sendKeys("123");

        WebElement recommendationYesBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class, 'button2023')]//span[text()='Да']")
        ));
        recommendationYesBtn.click();

        takeScreenshot("T2_S2_3_Форма_заполнена");

        WebElement previewBtn = driver.findElement(By.id("previewbtn"));
        previewBtn.click();

        WebElement alertWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.dia.diAlert.diError")
        ));

        WebElement alertElement = driver.findElement(By.cssSelector("span.dia-caption"));
        String alertText = alertElement.getText();

        takeScreenshot("T2_S2_4_Окно_с_ошибкой");

        Assert.assertTrue("Ошибка", alertText.contains("ВНИМАНИЕ!"));
    }
}

