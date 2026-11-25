import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumVyatsuTest extends SeleniumTest {
    private final String URL_VYATSU = "https://old.vyatsu.ru";

    @Test
    public void scenario1_getEducationalStandart(){
        driver.get(URL_VYATSU);
        takeScreenshot("S1_1_Открыт_сайт");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstLi = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='jsddm']/li[1]")
        ));

        Actions action = new Actions(driver);
        action.moveToElement(firstLi).perform();

        takeScreenshot("S1_2_Меню_раскрыто");

        WebElement targetMenuItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='jsddm']/li[1]/ul/li/a[contains(text(), 'Образовательные стандарты')]")
        ));
        targetMenuItem.click();

        wait.until(ExpectedConditions.titleContains("Образовательные стандарты"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Не удалось перейти на страницу стандартов! Текущий URL: " + currentUrl,
                currentUrl.contains("eduStandarts"));

        takeScreenshot("S1_3_Страница_стандартов");
    }

    @Test
    public void scenario2_searchOutputIsNotEmpty(){
        driver.get(URL_VYATSU);

        takeScreenshot("S2_1_Открыт_сайт");

        WebElement searchInput = driver.findElement(By.name("query"));
        searchInput.sendKeys("Отпуск");

        takeScreenshot("S2_2_Введен_запрос");

        searchInput.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement firstResult = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector(".column-center a")
                    )
            );
            Assert.assertTrue("Результаты поиска не пустые", firstResult.isDisplayed());

            takeScreenshot("S2_3_Результаты_поиска");

        } catch (TimeoutException e) {
            Assert.fail("Результаты поиска пусты");
        }
    }

    @Test
    public void scenario3_subscribeToNews() {
        driver.get(URL_VYATSU);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(., 'Студенту')]")).click();

        takeScreenshot("S3_1_Страница_Студенту");

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

        WebElement subscribeButton = driver.findElement(By.xpath("//input[@value='Подписаться на новости']"));

        emailInput.sendKeys("неверный-email");

        takeScreenshot("S3_2_Введен_неверный_email");

        subscribeButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert errorAlert = driver.switchTo().alert();
        String errorText = errorAlert.getText();
        Assert.assertTrue("Ожидалось сообщение об ошибке", errorText.contains("Неправильно введен e-mail"));
        errorAlert.accept();

        takeScreenshot("S3_3_После_ошибки_email");

        emailInput.clear();
        emailInput.sendKeys("test6@mail.ru");

        takeScreenshot("S3_4_Введен_верный_email");

        subscribeButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert successAlert = driver.switchTo().alert();
        String successText = successAlert.getText();


        Assert.assertTrue("Ожидалось сообщение об успехе", successText.contains("успешно добавлен в список рассылки"));
        successAlert.accept();
    }
}