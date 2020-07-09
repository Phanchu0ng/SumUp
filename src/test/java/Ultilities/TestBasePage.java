package Ultilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestBasePage {

        public static WebDriver driver;
        public static void openBrowser() {
            if (System.getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments(new String[]{"--no-sandbox"});
//            option.addArguments("--headless");
                driver = new ChromeDriver(option);
                driver.manage().window().maximize();
            } else if (System.getProperty("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions option = new FirefoxOptions();
                option.addArguments(new String[]{"--no-sandbox"});
//            option.addArguments("--headless");
                driver = new FirefoxDriver(option);
                driver.manage().window().maximize();
            }
        }
        public static WebDriver getDriver(){
            return driver;
        }
        public void tearDown() {
            driver.quit();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public static byte[] saveScreenshot() {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            return scrShot.getScreenshotAs(OutputType.BYTES);
        }

        @Attachment(value = "Log", type = "text/plain")
        public static String saveTextLog(String message) {
            return message;
        }

        @Attachment(value = "{0}", type = "text/html")
        public static String attachHtml(String html) {
            return html;
        }

        @Attachment(value = "Export File")
        public List<String> saveExportFile(String filePath, String charsetName) throws Exception {
            File file = new File(filePath);

            Charset charset = null;

            if ("UTF-8".equals(charsetName)) {
                charset = StandardCharsets.UTF_8;
            } else {
                charset = Charset.forName(charsetName);
            }
            return Files.readAllLines(Paths.get(file.getAbsolutePath()), charset);
        }


    }


