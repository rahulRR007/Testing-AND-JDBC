import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class App {
    public static void main(String[] args) throws Exception {
        ExtentSparkReporter extentspark = new ExtentSparkReporter("TestReport.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(extentspark);

        ExtentTest test = extent.createTest("TC001 - Search Product");

        test.pass("Enter the name");

        test.pass("check if the product is , listed");

        test.pass("add the product to the cart");

        extent.flush();

    }
}
