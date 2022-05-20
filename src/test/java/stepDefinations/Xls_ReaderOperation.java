package stepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Xls_ReaderOperation {

	String sheetName = null;
	String excelPath = null; 
	Xls_Reader excelRead = null;
	{
		try{
			sheetName = ReadAndWritePropertyFile.getPropertie("sheetName");
			excelPath = ReadAndWritePropertyFile.getPropertie("path");
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public  ArrayList<String> getCellDataForOrderID(String orderID) {
		excelRead = new Xls_Reader(excelPath);
		int columCont = excelRead.getColumnCount(sheetName);
		Xls_Reader excelRead = new Xls_Reader(excelPath);

		ArrayList<String> excelList = new ArrayList<String>(); 
		int rowNum  = excelRead.getCellRowNum(sheetName,"Order",orderID);
		if(rowNum != -1 ||columCont!= -1) {
			for(int columnIterator=0; columnIterator<columCont;columnIterator++) {
				excelList.add(excelRead.getCellData( sheetName,columnIterator, rowNum));
			}
		}
		else {
			System.out.println("Order Id or sheet name is not correct");
		}
		return excelList;
	}
}
