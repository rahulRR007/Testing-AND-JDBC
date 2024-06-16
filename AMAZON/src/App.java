
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) throws Exception {
       
        System.setProperty("driver.chrome.driver.", "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\AMAZON\\src\\Driver\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        WebElement searchbar = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
        searchbar.sendKeys("iphone 15 pro Max");

        String homeurl = driver.getCurrentUrl();
        System.out.println("Home url :"+homeurl);


        // String title = driver.getTitle();
        // System.out.println(title);
        // String currenturl = driver.getCurrentUrl();
        // System.out.println(currenturl);


        WebElement searchbtn  = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input"));
        searchbtn.click();  

        String currentUrl = driver.getCurrentUrl() ;
        System.out.println("Current url :"+currentUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")));
        item.click();

        Thread.sleep(5000);
        driver.close();
    }
}
