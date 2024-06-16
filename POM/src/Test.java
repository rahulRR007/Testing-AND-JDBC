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
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Test;

public class Test {

    WebDriver driver;

    @BeforeMethod

    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\POM\\src\\Driver");

        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/checkpoint/lg/sign-in-another-account");
    }

    @org.testng.annotations.Test(priority = 1)

    public void ValidLogin() {

        try {
            FileInputStream file = new FileInputStream(
                    "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\POM\\src\\file\\Itemname.xlsx");

            Workbook wb = WorkbookFactory.create(file);

            Sheet sheet = wb.getSheetAt(0);

            Row row = sheet.getRow(2);

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            WebElement a = driver.findElement(By.name("session_key"));

            WebElement b = driver.findElement((By.name("session_password")));

            WebElement button = driver.findElement(By.xpath("/html/body/div/main/div[2]/div[1]/form/div[3]/button"));

            a.sendKeys(username);
            b.sendKeys(password);

            button.click();

            Assert.assertTrue(driver.getCurrentUrl().contains("https://www.linkedin.com/feed/"), "Login Successful");

            wb.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @org.testng.annotations.Test(priority = 2)

    public void InLogin() {

        try {
            FileInputStream file = new FileInputStream(
                    "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\POM\\src\\file\\Itemname.xlsx");

            Workbook wb = WorkbookFactory.create(file);

            Sheet sheet = wb.getSheetAt(0);

            Row row = sheet.getRow(1);

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            WebElement a = driver.findElement(By.name("session_key"));

            WebElement b = driver.findElement((By.name("session_password")));

            WebElement button = driver.findElement(By.xpath("/html/body/div/main/div[2]/div[1]/form/div[3]/button"));

            a.sendKeys(username);
            b.sendKeys(password);

            button.click();

            Assert.assertTrue(driver.getCurrentUrl().contains("https://www.linkedin.com/feed/"), "Login Successful");

            wb.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
