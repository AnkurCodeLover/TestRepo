package stepDefinations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadAndWritePropertyFile {
	static String filePath = "C:\\TestAutomation\\Test Frameworks\\APIFramework_Latest\\src\\test\\java\\resources\\local.properties";
	static Properties prop = new Properties();
	static String value =null;
	static void setPropertie(String key,String value) throws IOException
	{
		try {
			FileOutputStream fileOutput = new FileOutputStream(filePath);
			prop.store(fileOutput, "Properties");
			prop.setProperty(key, value);
			fileOutput.close();
		} catch (FileNotFoundException fe) {
			System.out.println("Property file is not present on the location :" + filePath );
			fe.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static  String getPropertie(String key)throws IOException
	{
		try {
		FileInputStream fileInput=new FileInputStream(filePath);
		prop.load(fileInput);
		value = prop.getProperty(key);
		fileInput.close();
		
		} catch (FileNotFoundException fe) {
			System.out.println("Property file is not present on the location :" + filePath );
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}

