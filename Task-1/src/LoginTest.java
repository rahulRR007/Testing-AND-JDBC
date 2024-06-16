import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod

    public void test() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\Task-1\\src\\driver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.linkedin.com/checkpoint/lg/sign-in-another-account");

        driver.manage().window().maximize();

    }

    @Test
    public void Login() {
        try {
            FileInputStream file = new FileInputStream(
                    "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\Task-1\\src\\file\\Task-1.xlsx");

            Workbook wb = WorkbookFactory.create(file);

            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(2);

            String name = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            WebElement a = driver.findElement(By.xpath(password));
            WebElement b = driver.findElement(By.xpath(password));

            WebElement btn = driver.findElement(By.xpath(password));
            a.sendKeys(name);
            b.sendKeys(password);
            btn.click();

            wb.close();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

}
