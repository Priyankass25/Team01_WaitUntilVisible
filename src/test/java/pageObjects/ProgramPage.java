package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class ProgramPage {

	WebDriver driver;
	CommonMethods common;
	TestContextSetup context;

	public ProgramPage(WebDriver driver, TestContextSetup context) {
		this.driver = driver;
		this.common = new CommonMethods(driver);
	    this.context = context;

	}
	
//	private String programName ="RYLgBEgiLI";
	private String programName;
	
	public By manageProgmHeading = By.xpath("//div[contains(text() ,'Manage Program')]");
	public By formPosition = By.className("mat-card-title");
	public By topDeleteBtn = By.cssSelector("[ng-reflect-icon='pi pi-trash']");
	public By searchTextBox = By.id("filterGlobal");
	public By searchPlaceHolder = By.cssSelector("input[placeholder='Search...']");
	public By tableColumnHeaders = By.xpath("//thead[@class ='p-datatable-thead']//th");
	public By tableColumnHeaderCheckbox = By.xpath("//thead//div[@aria-checked = 'false']");
	public By bodyCheckboxes = By.xpath("//tbody//div[@role = 'checkbox']");
	public By tableColumnHeaderSort = By.xpath("//thead//th[@class = 'p-sortable-column']");
	public By rowsInAPage = By.xpath("//tbody//tr[@class='ng-star-inserted']");
	public By rightSinglePaginator = By.xpath("//span[contains(@class,'pi-angle-right')]/parent::button");
	public By editProgramBtn = By.id("editProgram");
	public By deleteProgramBtn = By.id("deleteProgram");
	public By paginationText = By.xpath("//span[contains(text(), 'entries')]");
	public By addProgramBtn = By.xpath("//div[@class = 'cdk-overlay-pane']//button[contains(@class,'mat-focus-indicator')]");
	public By programDetailsTitle = By.xpath("//div[contains(@class, 'p-dialog-header')]//span");
	public By asteriskName = By.xpath("//label[contains(text(), 'Name')]//span");
//	public By prgmName = By.xpath("//div//label[text()='Name']");
	public By prgmNameid = By.id("programName");
	public By asteriskStatus = By.xpath("//lable[contains(text(), 'Status')]//span");
	public By prgmDesc = By.xpath("//div//label[text()='Description']");
//	public By prgmStatus = By.xpath("//div//lable[text()='Status']");
	public By statusRadioBtns = By.xpath("//div//p-radiobutton");
	public By overlayBackdrop = By.cssSelector("div.cdk-overlay-backdrop.cdk-overlay-backdrop-showing");
	public By savePrgmBtn = By.id("saveProgram");
	public By prgmNameAlreadyExistError = By.xpath("//div//small");
	public By activeStatusCheckbox = By.xpath("//p-radiobutton[@ng-reflect-input-id='Active']");
	public By errMsgsEmptyPrgm = By.xpath("//small[contains(text(),'Program name is required.')]");
	public By errMsgsEmptyStatus = By.xpath("//small[contains(text(),'Status is required.')]");
	public By errMsgNumericPrgm = By.xpath("//small[contains(text(),'start with an alphabet')]");
	public By successMsgAddPrgm = By.xpath("//div[contains(@class, 'p-toast-detail')]");
	public By cancelBtn = By.xpath("//div//button[@ng-reflect-label='Cancel']");
	public By prgmDetailsVisible = By.xpath("//p-dialog[@header='Program Details']");
	public By prgmCloseBtn = By.xpath("//button//span[contains(@class,'p-dialog-header-close-icon')]");
	public By searchedPrgmName = By.xpath("//tr//td[2]");

	
	public boolean isManageProgramHeadingDisplayed() {
		return common.isDisplayed(manageProgmHeading);
	}
	
	public boolean isManageProgramHeadingLeftAligned() {
		int formX = driver.findElement(formPosition).getLocation().getX();
		int headingX = driver.findElement(manageProgmHeading).getLocation().getX();
	    return Math.abs(formX - headingX) <= 5;			
	}
	
	public boolean isTopDeleteButtonEnabled() {
		return common.isEnabled(topDeleteBtn);
	}
	
	public boolean isSearchBarVisible() {
		return common.isDisplayed(searchTextBox);
	}
	
	public boolean isSearchPlaceHolderTextDisplayed() {
		return common.isDisplayed(searchPlaceHolder);
	}
	
	public boolean isDataTableColumnHeadersDisplayed(String string) {
		List<WebElement> list = driver.findElements(tableColumnHeaders);
		for(WebElement e : list) {
			if(e.getText().trim().equalsIgnoreCase(string.trim())) {
				return e.isDisplayed();
			}				
		}
		return false;
	}
	
	public boolean isDataTableColumnHeaderCheckBoxEnabled() {
		return common.isEnabled(tableColumnHeaderCheckbox);
	}
	
	public boolean isBodyCheckboxesChecked() {
		List<WebElement> list = driver.findElements(bodyCheckboxes);
		for(WebElement e : list) {
			if(e.getAttribute("aria-checked").equalsIgnoreCase("true")) {
				return true;
			}				
		}
		return false; 
	}
	
	public boolean isDataTableColumnHeaderSortDisplayed() {
		List<WebElement> list = driver.findElements(tableColumnHeaderSort);
		for(WebElement e: list) {
			if(e.getAttribute("aria-sort").equals("none")) {
				return true;
			}
		}
		return false;
	}
	
	public void dismissOverlay() {
	    driver.findElement(overlayBackdrop).click();

	}
	
	public boolean isEditDeleteBtnsDisplayed() {
		dismissOverlay();
		do {
	        List<WebElement> rows = driver.findElements(rowsInAPage);
	        
	        if(rows.isEmpty()) {
	        	return false;
	        }
	        
	        for (WebElement row : rows) {
	            if (!row.findElement(editProgramBtn).isDisplayed()
	                    || !row.findElement(deleteProgramBtn).isDisplayed()) {
	                return false;
	            }
	        }
	        WebElement nextButton = driver.findElement(rightSinglePaginator);

	        if(nextButton.isEnabled()) {
	        	common.scrollIntoView(rightSinglePaginator);
                common.waitForClickable(rightSinglePaginator).click();
	        } else {
	            return true;
	        }

	    } while (true);
	}	
	
	public void addProgramBtnClick() {
		driver.findElement(addProgramBtn).click();
	}
	
	public boolean isProgramDetailsTitleDisplayed() {
		if (driver.findElement(programDetailsTitle).getText().equalsIgnoreCase("Program Details")) {
			return true;
		}
		return false;
		 
	}
	
	public boolean isAddProgramDialogDisplayed() {	
		return driver.findElement(addProgramBtn).getText().equalsIgnoreCase("Add New Program");
	}
	
	public boolean isNameStatusAsteriskDisplayed() {
		String aName = driver.findElement(asteriskName).getText();
		String aStatus = driver.findElement(asteriskStatus).getText();
	    return aName.equals("*") && aStatus.equals("*");
	}
	
	public boolean isNameTextBoxDisplayed() {
		return common.isDisplayed(prgmNameid);
	}
	
	public boolean isDescriptionTextBoxDisplayed() {
		return common.isDisplayed(prgmDesc);
	}
	
	public boolean isStatusRadioBtnsDisplayed() {
		List<WebElement> list = driver.findElements(statusRadioBtns);
		for(WebElement e : list) {
			String s = e.getAttribute("ng-reflect-value").trim();
			System.out.println("s valule is "+ s);
			if(s.equalsIgnoreCase("Active") || s.equalsIgnoreCase("Inactive")) {
				return true;
			}			
		}
		
		return false;
	}
	
	public void savePrgmBtnClick() {
		common.click(savePrgmBtn);
		}
	
	public void enterUniqueProgramNameSendKeys() {
//		String programName;	    
//	    do {
//	        programName = "LearnAI" + common.generateRandomString()+"WaitUntilVisible";
//	        driver.findElement(prgmName).clear();
//	        driver.findElement(prgmName).sendKeys(programName);
//	        common.sendKeys(prgmName, programName);programName
//	    } while (common.isDisplayed(prgmNameAlreadyExistError));
		programName = common.generateRandomString();
		common.sendKeys(prgmNameid, programName);
//	    context.setScenarioData(TestContextSetup.PROGRAM_NAME, programName);
	    LoggerLoad.info("programName is " + programName);
	}
	
	public void selectActiveStatus() {
		common.click(activeStatusCheckbox);
//		driver.findElement(activeStatusCheckbox).click();
	}
	
	public void enterNumericProgramNameSendKeys() {
		String programName = String.valueOf(common.generateRandomNumber());
		common.sendKeys(prgmNameid, programName);
	}
	
	public boolean areNameAndStatusErrMsgsDisplayed() {
	    return common.isDisplayed(errMsgsEmptyPrgm) && common.isDisplayed(errMsgsEmptyStatus);
	}
	
	public boolean isSuccessMsgDisplayed() {
		String actualResult = driver.findElement(successMsgAddPrgm).getText().trim();
		if (actualResult.contains("Program Created Successfully")) {
	    return true;}
		return false;
	}
	
	public boolean isNumericErrMsgDisplayed() {
	    return common.isDisplayed(errMsgNumericPrgm);
	}

	public void clickCancelBtn() {
		common.click(cancelBtn);
	}
	
	public boolean isPrgmDetailsFormDisappers() {
		String overlayVisible = driver.findElement(prgmDetailsVisible).getAttribute("ng-reflect-visible");
		return overlayVisible.equalsIgnoreCase("false");
	}
	
	public void clickCloseBtn() {
		common.click(prgmCloseBtn);
	}
	
	public void searchCreatedPrgm() {
		dismissOverlay();
//		String createdPrgm = (String) context.getScenarioData(TestContextSetup.PROGRAM_NAME);
//		LoggerLoad.info("Create Program Name is " +createdPrgm);
		LoggerLoad.info("Create Program Name is " +programName);

//		common.sendKeys(searchTextBox, createdPrgm);
		common.sendKeys(searchTextBox, programName);
	}
	
	public boolean searchedPrgmNameValidation() {
		common.waitForPresence(searchedPrgmName);

//		String createdPrgm = (String) context.getScenarioData(TestContextSetup.PROGRAM_NAME);
		String createdPrgm = programName;
		List<WebElement>list = driver.findElements(searchedPrgmName);
		for(WebElement e: list) {
			if(e.getText().contains(createdPrgm)) {
				return true;
			}
		}
		return false;
	}
}
