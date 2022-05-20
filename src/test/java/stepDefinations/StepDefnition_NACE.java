package stepDefinations;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefnition_NACE {

	@Given("set the location of excel file to property file named {string} and{string}")
	public void set_the_location_of_excel_file_to_property_file_named_and(String key, String value) throws IOException {
		ReadAndWritePropertyFile.setPropertie(key, value);
	}

	@When("Read the data for sheet name {string}")
	public void read_the_excel_file(String value) throws IOException {
		ReadAndWritePropertyFile.setPropertie("sheetName", value);
	}

	@Then("I validate the below value corresponding to the order id {string}")
	public void i_validate_the_below_value_corresponding_to_the_orader_id(String orderID, io.cucumber.datatable.DataTable dataTable) throws IOException {
		List<Map<String, String>>  dataList = dataTable.asMaps(String.class, String.class);
		Xls_ReaderOperation excelData = new Xls_ReaderOperation(); 
		ArrayList<String> excelArray = excelData.getCellDataForOrderID(orderID);
		Assert.assertEquals(dataList.get(0).get("Order"), excelArray.get(0));
		Assert.assertEquals(dataList.get(0).get("Level"), excelArray.get(1));
		Assert.assertEquals(dataList.get(0).get("Code"), excelArray.get(2));
		Assert.assertEquals(dataList.get(0).get("Parent"), excelArray.get(3));
		Assert.assertEquals(dataList.get(0).get("Description"), excelArray.get(4));
		Assert.assertEquals(dataList.get(0).get("This item includes"), excelArray.get(5));
		Assert.assertEquals(dataList.get(0).get("This item also includes"), excelArray.get(6));
		Assert.assertEquals(dataList.get(0).get("Rulings"), excelArray.get(7));
		Assert.assertEquals(dataList.get(0).get("This item excludes"), excelArray.get(8));
		Assert.assertEquals(dataList.get(0).get("Reference to ISIC Rev. 4"), excelArray.get(9));

	}
}
