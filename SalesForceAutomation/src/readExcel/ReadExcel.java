package readExcel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ReadExcel {

	public static String[][] readXlSheet(String dt_path,String sheetName) throws IOException
	{
		//Step1: Get the Xl Path
        File xlFile= new File(dt_path);
		
        //Step 2:Access the Xl file
		FileInputStream xlDoc=new FileInputStream(xlFile);
		
		//Step 3:Aceess the workbook
		HSSFWorkbook wb=new HSSFWorkbook(xlDoc);
		
		//Step 4:Access the worksheet
		HSSFSheet sheet=wb.getSheet(sheetName);
		
		HSSFRow row=sheet.getRow(0);
		HSSFCell cell=row.getCell(0);
		
		cell.setCellValue("Sangeetha updated this cell");
		
		FileOutputStream fout=new FileOutputStream(dt_path);
		wb.write(fout);
		fout.flush();
		fout.close();
		
		
	
		/*String data=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(data);*/
		
		int iRowCount=sheet.getLastRowNum()+1;
		int iColCount=sheet.getRow(0).getLastCellNum();
		
		String[][] xlData=new String[iRowCount][iColCount];
		
		for(int i=0;i<iRowCount;i++)
		{
			for(int j=0;j<iColCount;j++)
			    xlData[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			
		}
		return xlData;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String dt_path = "C:/Users/VHEGDE/Desktop/myworksheet.xls";
		
		String[][] recData = readXlSheet(dt_path,"Sheet1");
		
		for(int i=0;i<recData.length;i++)
		{
			for(int j=0;j<recData[0].length;j++)
			{
				System.out.print(recData[i][j]+" ");
			}
			System.out.println("");
		}
			
	}

}
