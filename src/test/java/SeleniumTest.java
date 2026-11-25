import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {
    protected WebDriver driver;
    private final String URL = "https://old.vyatsu.ru";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            takeScreenshot("FAILED_" + description.getMethodName());
            // Закрываем драйвер ЗДЕСЬ, после скриншота
            closeDriver();
        }

        @Override
        protected void succeeded(Description description) {
            closeDriver();
        }
    };

    private void closeDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
            } finally {
                driver = null;
            }
        }
    }

    public void takeScreenshot(String fileName) {
        if (driver == null) return;
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dir = new File("./screenshots");
            if (!dir.exists()) dir.mkdirs();
            File dest = new File(dir, fileName + ".png");
            FileUtils.copyFile(source, dest);
            System.out.println(">>> Скриншот сохранён: " + dest.getAbsolutePath());
        } catch (Exception e) {
            System.err.println(">>> Ошибка скриншота: " + e.getMessage());
        }
    }

    @Test
    public void titleTest() {
        driver.get(URL);
        Assert.assertEquals("Официальный сайт ВятГУ", driver.getTitle());
        takeScreenshot("SUCCESS_titleTest");
    }
}