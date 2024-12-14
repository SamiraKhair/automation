package basicscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;


public class BasicTestCase {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.apple.com/");
            Thread.sleep(2000);
            Actions actions = new Actions(driver);
            actions.scrollByAmount(0,500).perform();
            Thread.sleep(2000);
            actions.scrollByAmount(0,500).perform();
            Thread.sleep(2000);
            actions.scrollByAmount(0,500).perform();

        }
    }




