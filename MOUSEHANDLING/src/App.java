import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) throws Exception {
       System.setProperty("driver.chrome.driver", "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\MOUSEHANDLING\\src\\Driver\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.flipkart.com/");

       driver.manage().window().maximize();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        
       Actions action =  new Actions(driver);
       WebElement twowheelers  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[5]/div/div/span/span[1]")));
       action.moveToElement(twowheelers).perform();
       
       WebElement a = driver.findElement(By.xpath("/html/body/div[4]/div/object/a[1]"));
       WebElement b = driver.findElement(By.xpath("/html/body/div[4]/div/object/a[2]"));
      
       action.moveToElement(a).perform();
       action.moveToElement(b).click().build().perform();

       WebElement more = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[5]/div"));
       action.moveToElement(more).perform();

       WebElement NotificationPerferences = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[5]/div/div/div[2]/div[2]/div/ul/li[1]/a"));
       action.moveToElement(NotificationPerferences).perform();

       WebElement Customer24x7_care = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[5]/div/div/div[2]/div[2]/div/ul/li[2]/a"));
       action.moveToElement(Customer24x7_care).click().build().perform();

       Thread.sleep(6000);
       driver.quit();

    }
}
