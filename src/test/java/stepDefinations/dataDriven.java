package stepDefinations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	@SuppressWarnings("resource")
	public ArrayList<String> getData(String key_OrderID)
	{

		ArrayList<String> arrList=new ArrayList<String>();
		Properties prop = new Properties();
		try {
			FileInputStream InputStream;

			InputStream = new FileInputStream(ReadAndWritePropertyFile.getPropertie("path"));

			XSSFWorkbook workbook;

			workbook = new XSSFWorkbook(InputStream);
			DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale

			int totalSheet =workbook.getNumberOfSheets();
			for(int sheetCount=0;sheetCount<totalSheet;sheetCount++)// Rename i
			{
				if(workbook.getSheetName(sheetCount).equalsIgnoreCase(ReadAndWritePropertyFile.getPropertie("sheetName")))
				{
					XSSFSheet subSheet=workbook.getSheetAt(sheetCount);
					Iterator<Row>  rowsIterator= subSheet.iterator();// sheet is collection of rows
					Row firstrow= rowsIterator.next();
					Iterator<Cell> cell=firstrow.cellIterator();//row is collection of cells

					int columnCount=0;
					int column = 0;
					while(cell.hasNext())
					{
						Cell value=cell.next();
						if(value.getStringCellValue().equalsIgnoreCase("Order"))
						{
							column=columnCount;
						}		
						columnCount++;
					}
					System.out.println(columnCount);
					while(rowsIterator.hasNext())
					{
						Row excelRows=rowsIterator.next();
						String num = formatter.formatCellValue(excelRows.getCell(column));
						if(num.equalsIgnoreCase(key_OrderID))
						{
							Iterator<Cell>  cellIterator=excelRows.cellIterator();	
							for(int j = columnCount;j>=0;j--)
							{						
								Cell subCell =	cellIterator.next();
								if(subCell.getCellTypeEnum()==CellType.STRING)
								{	
									arrList.add(subCell.getStringCellValue());
								}
								else{arrList.add(NumberToTextConverter.toText(subCell.getNumericCellValue()));

								}
								System.out.println("inside the for loop :" + j);	
							}
						}
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return arrList;
	}
}
