package TestNGPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
    //commonly used variables are declared
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path=null; //
	
	//constructor is created
	//Whenever we create the object of this class, we have to pass location of the Excel file
	XLUtility(String path)
	{
		this.path=path;//assign path to the local variable
	}
	
	// to get the row count
	public int getRowCount(String sheetName) throws IOException // take parameter as Sheet name
	{
		fi=new FileInputStream(path);//FleInputstream to open Excel
		workbook=new XSSFWorkbook(fi);//from the file get the workbook
		sheet=workbook.getSheet(sheetName);//from the workbook get the sheet
		int rowcount=sheet.getLastRowNum();//from that sheet find the last row number, i.e., the rowcount
		workbook.close();//close the workbook
		fi.close();//close the file input stream
		return rowcount; //return the rowcount		
	}
	
    //to get the  cell count
	public int getCellCount(String sheetName,int rownum) throws IOException //take parameters as sheetname and row count
	{
		fi=new FileInputStream(path);//open the file in InputStream mode 
		workbook=new XSSFWorkbook(fi);//from the file get the workbook
		sheet=workbook.getSheet(sheetName);//from the workbook get the sheet
		row=sheet.getRow(rownum);//get the particular row
		int cellcount=row.getLastCellNum();//from that row get the last cell number, that is exactly the number of cells in that row
		workbook.close();//close workbook
		fi.close();//close fileinputstream
		return cellcount;//return cell count
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException //take sheet name, row num, col num as argument
	//getcellData is used when we read the data from Excel
	//This method will return the data from the cell
	{
		fi=new FileInputStream(path);//open  the file in fileinputstream mode
		workbook=new XSSFWorkbook(fi);//from the file get the workbook
		sheet=workbook.getSheet(sheetName);////from the workbook get the sheet
		row=sheet.getRow(rownum);//from that get the row
		cell=row.getCell(colnum);//from that row, get the col
		
		//from the cell we have to extract data
		//the cell may contain String, Integer or boolean data,Date
		
		//We read the data from the excel sheet as One string format, because in the application we are passing the String data
		//to do this, In Apache Poi we have class called DataForamtter
		
		DataFormatter formatter = new DataFormatter();//create object of DataFormatter
		String data;
		try{                                     //Formatter.cellvalue(cell), method
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";//if the cell value is empty, throws exception, we are adding some empty value
		}
		workbook.close();//close the workbook
		fi.close();//close the file input stream
		return data;//return the data from the cell
	}
	
	//to write the data back into the cell
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException//take sheet name,cell num, row num and data as parameter
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fo=new FileOutputStream(path);
		workbook.write(fo);
		}
				
		fi=new FileInputStream(path);//get the file in inputstream mode
		workbook=new XSSFWorkbook(fi);//get the workbook
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		
		sheet=workbook.getSheet(sheetName);//get the sheet
					
		if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
				sheet.createRow(rownum);
		row=sheet.getRow(rownum);//get the row
		
		cell=row.createCell(colnum);//get the cell
		cell.setCellValue(data);//pass the data in the cell
		
		fo=new FileOutputStream(path);//open the file in outputstram mode
		workbook.write(fo);	//write the workbok into the file	
		workbook.close();//close the workbook
		fi.close();//close file input stream
		fo.close();//close file output stream
	}
	
	//to add green color to the cell
	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		//Inside the cell we have to apply foreground color
		//to apply fore ground color we have method called woorkbook.createcellStyle();
		style=workbook.createCellStyle();//return cellstyle object
		//apply foreground color
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);//apply the style to the particular cell
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cell.setCellStyle(style);		
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
}