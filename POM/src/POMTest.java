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

public class POMTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\POM\\src\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void performCheckout() {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        try {
            FileInputStream file = new FileInputStream(
                    "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\POM\\src\\file\\Itemname.xlsx");

            Workbook workbook = WorkbookFactory.create(file);

            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(1);

            String productName = row.getCell(0).getStringCellValue();

            WebElement searchBox = driver.findElement(By.xpath(
                    "/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));

            searchBox.sendKeys(productName);

            searchBox.submit();

            WebElement prod = driver
                    .findElement(By.xpath(
                            "/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a/div[1]/div/div/div/img"));

            prod.click();

            String currentTab = driver.getWindowHandle();
            for (String tab : driver.getWindowHandles()) {
                if (!tab.equals(currentTab)) {
                    driver.switchTo().window(tab);
                    break;
                }
            }

            WebElement addToCartButton = driver
                    .findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
            assert addToCartButton != null : "Add to cart button not found";
            addToCartButton.click();

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}