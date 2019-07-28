  package datainput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class WritingExcelFile {

	public static void main(String[] args) throws IOException {
		File file= new File("C:\\Users\\Shahin Alam\\eclipse-workspace\\DataInput\\src\\datainput\\Excel.xlsx.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);
		
		//int totalrow= sheet.getLastRowNum();
		//System.out.println("total rows are"+totalrow);
		
		sheet.getRow(0).createCell(5).setCellValue("States");
		sheet.getRow(1).createCell(5).setCellValue("=>pass");
		sheet.getRow(2).createCell(5).setCellValue("=>pass");
		sheet.getRow(3).createCell(5).setCellValue("=>123.54");
		sheet.getRow(4).createCell(5).setCellValue("04-09-19");
		
		//write excel data
		System.out.println("writing excel");
		FileOutputStream output= new FileOutputStream(file);
		wb.write( output);
		wb.close();
		
		//read excel data
		//String data0=sheet.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(data0);
  }

 }
 