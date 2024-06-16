import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        String location = "C:\\Users\\rahul\\OneDrive\\Desktop\\Testing Course\\project\\POI\\src\\file\\Book1.xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook(location);

        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= 3; i++) {
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < 2; j++) {
                XSSFCell cell = row.getCell(j);
                String value = cell.getStringCellValue();

                System.out.println(value);
            }

        }

        workbook.close();

    }
}
