import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\LINKEDIN\\src\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.linkedin.com/login");
        driver.manage().window().maximize();

        WebElement emailorPhone = driver.findElement(By.name("session_key"));
        WebElement Password = driver.findElement(By.name("session_password"));
        WebElement singin_bt = driver.findElement(By.xpath("/html/body/div/main/div[2]/div[1]/form/div[3]/button"));

        emailorPhone.sendKeys("rahulramasamy2026@gmail.com");
        Password.sendKeys("Rahul@2005");

        if(!singin_bt.isSelected())
        {
            singin_bt.click();
        }

        Thread.sleep(20000);
        driver.close();

    }
}
