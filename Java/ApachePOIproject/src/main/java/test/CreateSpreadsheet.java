package test;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class CreateSpreadsheet {
	
	public static void main(String[] args)throws Exception {
	      XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("Sheet Name");
	      XSSFRow row = spreadsheet.createRow((short)1);
	      
	      FileOutputStream out = new FileOutputStream(new File("C:\\Users\\BD01813603\\Desktop\\Workspace\\createworkbook.xlsx"));

	      workbook.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
	   }

}
