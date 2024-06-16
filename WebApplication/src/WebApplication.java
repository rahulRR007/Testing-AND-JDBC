import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class WebApplication {
    WebDriver driver;

    @BeforeMethod

    public void setup()

    {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\WebApplication\\src\\Driver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        try {
            FileInputStream file = new FileInputStream(
                    "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\WebApplication\\src\\file\\Book1.xlsx");

            Workbook workbook = WorkbookFactory.create(file);

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1);

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.tagName("button")).click();

            workbook.close();

        } catch (Exception e)

        {

            e.printStackTrace();

        }

    }

    @Test
    public void testLoginSucess() {
        WebElement successElement = driver.findElement(By.cssSelector(".flash.sucess"));

    }

    @Test

    public void testLoginFailure() {
        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.erro"));
    }

}
