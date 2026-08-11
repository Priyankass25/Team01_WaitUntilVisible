package utilities;
import java.util.List;
import java.util.Map;



public class TestDataManager {

	private ExcelUtils excelUtils; 
	public TestDataManager() { 
		excelUtils = new ExcelUtils(); 
	}
	
	
	public List<Map<String, String>> getTestData(String sheetName) { 
		return excelUtils.getDataAll(sheetName); }
}
