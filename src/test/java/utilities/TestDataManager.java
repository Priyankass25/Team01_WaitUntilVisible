package utilities;

import java.util.List;
import java.util.Map;

public class TestDataManager {

	private ExcelUtils excelUtils;

	public TestDataManager() {
		String filePath = ConfigReader.getProperty("test_data_path");
		ExcelUtils excelUtils = new ExcelUtils(filePath);
	}

	public List<Map<String, String>> getTestData(String sheetName) {
		return excelUtils.getDataAll(sheetName);
	}
}
