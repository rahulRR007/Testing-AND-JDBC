import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("driver.chrome.driver",
                "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\FLIPCART\\src\\Driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        WebElement searchbar = driver.findElement(By.xpath(
                "/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));

        String homeurl = driver.getCurrentUrl();
        System.out.println("Home url : " + homeurl);
        searchbar.sendKeys("nike");

        searchbar.submit();

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a/div[1]/div/div/div/img")));
        item.click();

        // WebElement cart_btn =
        // driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button
        // "));
        // cart_btn.click();

        // Store the current window handle
        String mainWindow = driver.getWindowHandle();

        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        // Perform actions in the new tab
        Thread.sleep(10000);
        // Close the new tab
        driver.close();
        // Switch back to the main window
        driver.switchTo().window(mainWindow);

        driver.navigate().back();

        Thread.sleep(2000);
        driver.close();

    }
}
