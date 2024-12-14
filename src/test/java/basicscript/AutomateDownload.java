package basicscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.Map;

public class AutomateDownload {
    public static void main(String[] args) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0); // Disable download popups
        prefs.put("download.default_directory", "C:\\Users\\Samir\\Downloads"); // Set download directory
        prefs.put("download.prompt_for_download", false); // Disable download prompt
        prefs.put("download.directory_upgrade", true); // Allow overwrites

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);


        try {
            // 1. Navigate to the website
            driver.get("http://172.16.50.14/"); // Replace with the target website URL
            driver.manage().window().maximize();
            Thread.sleep(5000); // Wait for the page to load

            // 2. Click on the dropdown menu from the nav bar
            WebElement dropdownMenu = driver.findElement(By.xpath("//a[text()='Movies']")); // Replace with the actual dropdown menu ID
            dropdownMenu.click();
            Thread.sleep(3000); // Allow animation time

            // 3. Select a category
            WebElement category = driver.findElement(By.xpath("//a[text()='Hindi Movies']")); // Replace with the actual category XPath or text
            category.click();
            Thread.sleep(5000); // Wait for the category page to load

            WebElement sideNavBar = driver.findElement(By.id("tree"));

            // Scroll within the side navigation bar
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", sideNavBar); // Scroll to the bottom of the nav bar
            Thread.sleep(2000); // Pause to let the scroll finish

            // Scroll back to the top of the side navigation bar
            js.executeScript("arguments[0].scrollTop = 0", sideNavBar);
            Thread.sleep(2000);



            // Locate the folder within the side nav bar
            WebElement folder = driver.findElement(By.xpath("//span[@class='label' and text()='2024']")); // Replace with actual XPath
            folder.click(); // Click on the folder
            System.out.println("Folder selected!");

            //random

            // Additional actions can be added here
            Thread.sleep(2000);

            WebElement folder2 = driver.findElement(By.xpath("//span[@class='label' and text()='Adbhut (2024) 720p HDTV']")); // Replace with actual XPath
            folder2.click(); // Click on the folder





            // 4. Select the search bar and type a movie name
            // Locate the search bar by class name
//            WebElement searchBar = driver.findElement(By.xpath("//input[@class='l10n_ph-search']"));
//
// Click on the search bar to focus (optional)
//            searchBar.click();
//
// Type a search term into the search bar
//            searchBar.sendKeys("Jigra");
//
// Submit the search (if applicable)
//            searchBar.submit();
//
//            searchBar.submit(); // Submit the search form
//            Thread.sleep(3000); // Wait for the search results page to load

            // 5. Click on the folder containing the movie file


            // 6. Click on the movie file
            WebElement movieFile = driver.findElement(By.xpath("//span[@class= 'label' and text()='Adbhut (2024) Hindi 720p HDTVRip x264 AAC - mkvCinemas.mkv']")); // Replace with actual movie file XPath
            movieFile.click();

            System.out.println("Movie file clicked without download popup.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


