package utilities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import driverFactorySetUp.DriverFactory;

public class CommonMethods {
	public static WebDriver driver;
	public static WebDriverWait wait;
	//ExcelUtils excel = new ExcelUtils(driver);
	//ExcelUtils excel;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//ExcelUtils excel = new ExcelUtils(driver);

	}



	public By usernameTextbox = By.id("username");
	public By passwordTextbox = By.id("password");
    public By selectTheRole=By.xpath("//span[text()='Select the role']");
    public By Admin=By.id("mat-option-0");
    public By dropdownClose=By.tagName("body");
	public By loginButtonUI = By.xpath("//span[text()='Login']");


	public void loginFromOnBoarding() {
		ConfigReader.loadProperties();
		ExcelUtils excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
		String username = excel.getDataAll("Login").get(0).get("User");
		String password = excel.getDataAll("Login").get(0).get("Password");
		
		driver.findElement(selectTheRole).click();
		driver.findElement(Admin).click();
		driver.findElement(dropdownClose).click();


		driver.findElement(loginButtonUI).click();
	
	}
	public void loginFromOnBoarding1() {
		ConfigReader.loadProperties();
		ExcelUtils excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
		List<Map<String, String>> data =
		        excel.getDataAll("Login");
	    Map<String, String> row = data.get(0);
	    String username = row.get("User");
	    String password = row.get("Password");

		
		driver.findElement(usernameTextbox).sendKeys(username);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(selectTheRole).click();
		driver.findElement(Admin).click();
		driver.findElement(dropdownClose).click();


		driver.findElement(loginButtonUI).click();

	}



	public void loginFromOnBoarding2() {

	    ConfigReader.loadProperties();

		ExcelUtils excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));


	    List<Map<String, String>> data =
	            excel.getDataAll("Login");

	    Map<String, String> row = data.get(0);

	    String username = row.get("User");
	    String password = row.get("Password");

	    System.out.println("=================================");
	    System.out.println("Current URL: " + driver.getCurrentUrl());
	    System.out.println("Page Title: " + driver.getTitle());
	    System.out.println("=================================");

	    // Wait for username field
	   /* WebElement usernameField = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(usernameTextbox)
	    );

	    usernameField.clear();
	    usernameField.sendKeys(username);

	    // Wait for password field
	    WebElement passwordField = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(passwordTextbox)
	    );

	    passwordField.clear();
	    passwordField.sendKeys(password);*/
	    waitForVisibility(usernameTextbox).sendKeys(username);
	    waitForVisibility(passwordTextbox).sendKeys(password);

	    // Select role
	    wait.until(
	            ExpectedConditions.elementToBeClickable(selectTheRole)
	    ).click();

	    wait.until(
	            ExpectedConditions.elementToBeClickable(Admin)
	    ).click();

	    // Close role dropdown
	    wait.until(
	            ExpectedConditions.elementToBeClickable(dropdownClose)
	    ).click();

	    // Login
	    wait.until(
	            ExpectedConditions.elementToBeClickable(loginButtonUI)
	    ).click();

	    System.out.println("Login username: " + username);
	    System.out.println("Login completed");
	}


	public static WebElement waitForVisibility(By locator) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public WebElement waitForClickable(By locator) {
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public String generateRandomString() {
		String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() <10) { 
			int index = rnd.nextInt(CHARSET.length());
			salt.append(CHARSET.charAt(index));
		}
		return salt.toString();
	}
	
	public boolean isDisplayed(By locator) {
		try {
			return waitForVisibility(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (Exception e) {
			return toString();
		}
	}


	public boolean isEnabled(By locator) {
		try {
			return waitForVisibility(locator).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public void click(By locator) {
		waitForClickable(locator).click();
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
		}

	/*public static boolean webClickByLocator(By locator) {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(500)).ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);

		try {
			WebElement element = fluentWait.until(d -> d.findElement(locator));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().perform();
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Failed to click element after Fluent Wait: " + locator);
			return false;
		}
	}*/
  
	/*public void waitForPopupToDisappear(By Locator) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(Locator));
		} catch (Exception e) {
			LoggerLoad.info("Pop up cannot be closed");
		}
	}*/

	/*public static String waitForDomAttribute(By locator, String attribute, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(timeoutInSeconds));
			return wait.until(driver -> driver.findElement(locator).getDomAttribute(attribute));
		} catch (Exception e) {
			LoggerLoad.error("Failed to get DOM attribute '" + attribute + "' for element: " + locator + ". Exception: "
					+ e.getMessage());
			return "";
		}
	}*/
       
	/*public int getElementsCount(By locator) {
		return driver.findElements(locator).size();
	}*/

	/*public List<String> getElementsListText(By locator) {

		List<WebElement> elements = driver.findElements(locator);
		List<String> texts = new ArrayList<>();

		for (WebElement element : elements) {
			String text = element.getText().trim();
			if (!text.isEmpty()) {
				texts.add(text);
			}
		}

		return texts;
	}*/
	
	public int generateRandomNumber() {
		return new Random().nextInt(1000);
	}

	
	
	/*public WebElement randomCheckboxSelection(By locator) {
		List<WebElement> checkboxesNew = driver.findElements(locator);

		Random random = new Random();
		int randomIndex = random.nextInt(checkboxesNew.size());
		WebElement randomCheckbox = checkboxesNew.get(randomIndex);
		return randomCheckbox;
	}*/

	/*public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	}

	public void scrollIntoView(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		scrollIntoView(element);
	}*/
	
	public void scrollIntoView(By locator) {

	    WebElement element =
	        wait.until(
	            ExpectedConditions.visibilityOfElementLocated(locator)
	        );

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block:'center'});",
	        element
	    );
	}

	/*public String getAlertText() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert.getText();
	}*/

	/*public void enterTextAndAcceptAlert(String text) {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys(text);
		alert.accept();
	}*/

//	public void dismissAlert() {
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		alert.dismiss();
//	}

	/*public String getCurrentDate() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}*/

//	public List<WebElement> getElements(By locator) {
//		return driver.findElements(locator);
//	}

	public void sendKeys(By locator, String text) {
		WebElement element = waitForVisibility(locator);
		element.clear();
		element.sendKeys(text);
	}

	/*public void scrollIntoViewWait(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});",
				element);
		wait.until(ExpectedConditions.visibilityOf(element));
	}*/

// 
//       public void scrollToBottomPage() {
//    	   JavascriptExecutor js = (JavascriptExecutor) driver;
//
//    	   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//       }
}
