import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\FACEBOOK\\src\\Driver\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/signup/");
        driver.manage().window().maximize();//fullscreen
        WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement surName = driver.findElement(By.name("lastname"));
        WebElement mobile_email = driver.findElement(By.name("reg_email__"));
        WebElement Password = driver.findElement(By.name("reg_passwd__"));
        WebElement bd_day = driver.findElement(By.name("birthday_day"));
        WebElement bd_month = driver.findElement(By.name("birthday_month"));
        WebElement bd_year = driver.findElement(By.name("birthday_year"));
        WebElement gender = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/label"));
        WebElement but = driver.findElement(By.name("websubmit"));
        
        firstName.sendKeys("Rahul");
        surName.sendKeys("Kumar");

        mobile_email.sendKeys("9876543210");
        Password.sendKeys("Rahul@2005");

        bd_day.sendKeys("1");
        bd_month.sendKeys("Feb");

        bd_year.sendKeys("2005");
        
        if(!gender.isSelected())
        {
            gender.click();
        }
        if(!but.isSelected())
        {
            but.click();
        }

        Thread.sleep(10000);
        driver.close();
    }
}
