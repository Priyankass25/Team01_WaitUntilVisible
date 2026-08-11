package pageObjects;
import java.awt.Dimension;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class ProgramPage {

	WebDriver driver;
	CommonMethods common;
	WebDriverWait wait;
	TestContextSetup context;


	public ProgramPage(WebDriver driver, TestContextSetup context) {
		this.driver = driver;
		this.common = new CommonMethods(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    this.context = context;
	}
	
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
	public By prgmNameid = By.id("programName");
	public By asteriskStatus = By.xpath("//lable[contains(text(), 'Status')]//span");
	public By prgmDesc = By.xpath("//div//label[text()='Description']");
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
	public By searchedPrgmDesc = By.xpath("//tr//td[3]");
	public By editPrgmNameInput = By.xpath("//input[@id='programName']");
	public By editPrgmDescInput = By.xpath("//input[@id='programDescription']");
	public By inActiveStatusCheckbox = By.xpath("//p-radiobutton[@ng-reflect-input-id='Inactive']");
	public By deleteConfirmPopup = By.xpath("//div//span[text()='Confirm']");
	public By deleteConfirmPopupNoBtn = By.xpath("//div//button[@ng-reflect-ng-class='p-confirm-dialog-reject']");
	public By deleteConfirmPopupYesBtn = By.xpath("//div//button[@ng-reflect-ng-class='p-confirm-dialog-accept']");
	public By zeroPrgmSearchResultMsg = By.xpath("//span[contains(text(),'Showing 0 to 0 of 0 entries')]");
	public By deleteCrossMarkConfirmBtn = By.xpath("//button[contains(@class,'p-dialog-header-close')]");
	public By onePrgmSearchResultMsg = By.xpath("//span[contains(text(),'Showing 1 to 1 of 1 entries')]");
	public By totalPrgmCount = By.xpath("//div[contains(@class,'p-datatable-footer')]//div");
	
	//sowmya
	public	 By textp = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr[1]/td[2]");
	public	 By progde = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr[1]/td[3]");
	public  By progst = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr[1]/td[4]");
	public  By zeroent = By.xpath("//*[text()='1']");
	public   By programname = By.xpath("//*[@psortablecolumn='programName']");
	public By tablelist = By.xpath("//*[@class='p-datatable-wrapper ng-star-inserted']");
	public By overlay = By.cssSelector("div.cdk-overlay-backdrop.cdk-overlay-backdrop-showing");
	public By programdescription = By.xpath("//*[@psortablecolumn='programDescription']");
	public By programstatus = By.xpath("//*[@psortablecolumn='programStatus']");
	public By nextarrow = By.xpath("//*[@class='p-paginator-icon pi pi-angle-right']");
	public By selectnumb=By.xpath("//*[text()='1']");
	public By selectnumbr=By.xpath("//*[text()='2']");
	public By lastarrow=By.xpath(" //*[@class='p-paginator-icon pi pi-angle-double-right']");
	public By totalPrograms = By.xpath("//*[text()=' In total there are 99 programs. ']");
	public By infototal= By.xpath("//*[@class='p-paginator-current ng-star-inserted']");
	public  By prearrow= By.xpath("//*[@ng-reflect-ng-class=\"p-paginator p-component\"]/button[2]");
	   public By firstarrow= By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[1]");

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
	
	public void topDeleteButtonClick() {
		common.click(topDeleteBtn);;
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

	 public void searchboxenter() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox)).sendKeys("Python");
   }
   public void searchboxdes() {
   wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox)).sendKeys("Coding Details");
}
	 public boolean progname() {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(textp)).isDisplayed();
   }
	     public boolean progdes() {
   return wait.until(ExpectedConditions.visibilityOfElementLocated(progde)).isDisplayed();
}
public boolean progstatus() {
   return wait.until(ExpectedConditions.visibilityOfElementLocated(progst)).isDisplayed();
}
public void searchboxnotex() {
wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox)).sendKeys("Java Script");
}
public String entries() {
return "0";
}
public String zeroentries() {
return wait.until(ExpectedConditions.visibilityOfElementLocated(zeroent)).getText();
}
public void searchboxpar() {
wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox)).sendKeys("Py");
}
public void clickprogramname() {
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
	    WebElement sortIcon = wait.until(ExpectedConditions.elementToBeClickable(programname));
	    sortIcon.click();
}
public List<String> getProgramNames() {

    List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tablelist));
    List<String> programNames = new ArrayList<>();
    for (WebElement element : elements)
    { String name = element.getText().trim();
       if (!name.isEmpty()) {
        programNames.add(name);
        } }
//System.out.println(programNames);
    return programNames;
}
public boolean isProgramNameSortedAscending() {

    List<String> actual = getProgramNames();
    List<String> expected = new ArrayList<>(actual);
 expected.sort(String.CASE_INSENSITIVE_ORDER);
 //  System.out.println("Actual   : " + actual);
   // System.out.println("Expected : " + expected);
    return actual.equals(expected);
   
}
public boolean isProgramNameSortedDescending() {

    List<String> actual = getProgramNames();
 List<String> expected = new ArrayList<>(actual);
    expected.sort(String.CASE_INSENSITIVE_ORDER.reversed());
    return actual.equals(expected);
}
public void programdescriptionclick() {
	wait.until(ExpectedConditions.elementToBeClickable(programdescription)).click();
	
}
public void lastarrowclick() {
	wait.until(ExpectedConditions.elementToBeClickable(lastarrow)).click();
	
}
public void prearrowclick() {
	wait.until(ExpectedConditions.elementToBeClickable(prearrow)).click();
	
}
public void firstarrowclick() {
	wait.until(ExpectedConditions.elementToBeClickable(firstarrow)).click();
	
}
public void programstatusclick() {
	wait.until(ExpectedConditions.elementToBeClickable(programstatus)).click();
	
}
public void nextarrowclick() {
	wait.until(ExpectedConditions.elementToBeClickable(nextarrow)).click();
	
}
public String getslectednum() {
   String txt= wait.until(ExpectedConditions.visibilityOfElementLocated(selectnumb)).getText().trim();
   int number = Integer.parseInt(txt);
   return String.valueOf(number);
}
public String getslectednumb() {
	   String txt= wait.until(
	        ExpectedConditions.visibilityOfElementLocated(selectnumbr)).getText().trim();
	   int number = Integer.parseInt(txt);
	   return String.valueOf(number);
	}
public String getafterarrowclk() {
    String text = wait.until(
        ExpectedConditions.visibilityOfElementLocated(selectnumb)).getText().trim();
    int number = Integer.parseInt(text);
    return String.valueOf(number + 1);
}
public String getaprearrowclk() {
    String text = wait.until(
        ExpectedConditions.visibilityOfElementLocated(selectnumbr)).getText().trim();
    int number = Integer.parseInt(text);
    return String.valueOf(number - 1);
}
public List<String> getProgramDescriptions() {

    List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tablelist));
    List<String> descriptions = new ArrayList<>();
    for (WebElement element : elements) {
        String description = element.getText().trim();
        if (!description.isEmpty()) {
        descriptions.add(description);
        }
    }
    System.out.println(descriptions);
    return descriptions;
    
}
public boolean isProgramDescriptionSortedAscending() {

    List<String> actual = getProgramDescriptions();
    List<String> expected = new ArrayList<>(actual);
    expected.sort(String.CASE_INSENSITIVE_ORDER);
    return actual.equals(expected);
}
public boolean isProgramDescriptionSortedDescending() {
    List<String> actual = getProgramDescriptions();
    List<String> expected = new ArrayList<>(actual);
    expected.sort(String.CASE_INSENSITIVE_ORDER.reversed());
   return actual.equals(expected);
    
}
public List<String> getProgramstatus() {

    List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tablelist));
    List<String> descriptions = new ArrayList<>();
    for (WebElement element : elements) {
        String description = element.getText().trim();
        if (!description.isEmpty()) {
            descriptions.add(description);
        }
    }
    System.out.println(descriptions);
    return descriptions;
    
}
public boolean isProgramstatusSortedAscending() {

    List<String> actual = getProgramDescriptions();
    List<String> expected = new ArrayList<>(actual);
    expected.sort(String.CASE_INSENSITIVE_ORDER);
    return actual.equals(expected);
}
public boolean isProgramstatusSortedDescending() {

    List<String> actual = getProgramDescriptions();
    List<String> expected = new ArrayList<>(actual);
 expected.sort(String.CASE_INSENSITIVE_ORDER.reversed());
     return actual.equals(expected);
}

public int getTotalPrograms() {

	String text = wait.until(ExpectedConditions.visibilityOfElementLocated(infototal)).getText().trim();
String[] numbers = text.replaceAll("[^0-9 ]", " ").trim().split("\\s+");
	    return Integer.parseInt(numbers[2]);
	
}
public int getDisplayedEntries() {

    String text = wait.until(ExpectedConditions.visibilityOfElementLocated(infototal)).getText().trim();
String[] numbers = text.replaceAll("[^0-9 ]", " ").trim().split("\\s+");
return Integer.parseInt(numbers[1]);
}
public int getFirstNumber() {
 String text = wait.until(ExpectedConditions.visibilityOfElementLocated(infototal)).getText().trim();
    String[] numbers = text.replaceAll("[^0-9 ]", " ").trim().split("\\s+");
    return Integer.parseInt(numbers[0]);
}


	
	public void savePrgmBtnClick() {
		common.click(savePrgmBtn);
		}
	
	public void enterUniqueProgramNameSendKeys() {
		programName = common.generateRandomString();
		common.sendKeys(prgmNameid, programName);
	    LoggerLoad.info("programName is " + programName);
	}
	
	public void prgmNameEnter(String string) {
		common.sendKeys(prgmNameid, string);

	}
	

	public void selectActiveStatus() {
		common.click(activeStatusCheckbox);
	}
	
	public void enterNumericProgramNameSendKeys() {
		String programName = String.valueOf(common.generateRandomNumber());
		common.sendKeys(prgmNameid, programName);
	}
	
	public boolean areNameAndStatusErrMsgsDisplayed() {
	    return common.isDisplayed(errMsgsEmptyPrgm) && common.isDisplayed(errMsgsEmptyStatus);
	}
	
	public boolean isSuccessMsgDisplayed() {
		String actualResult = common.getText(successMsgAddPrgm);
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
	
	public void searchPrgm(String string) {
		common.sendKeys(searchTextBox, string);
	}
	
	public boolean searchedPrgmNameValidation(String string) {
		common.waitForPresence(searchedPrgmName);
		List<WebElement>list = driver.findElements(searchedPrgmName);
		for(WebElement e: list) {
			if(e.getText().contains(string)) {
				return false;
			}
		}
		return true;
	}
	
	public String generateRandomPrgmName() {
		return common.generateRandomString();
	}
	
	public void editBtnClick() {
		common.click(editProgramBtn);
	}
	
	public void editProgramSave(String string) {
				
		if(string.equalsIgnoreCase("name")) {
			String name = common.generateRandomString();
			common.randomCheckboxSelection(editPrgmNameInput);
			common.sendKeys(editPrgmNameInput, name );
			LoggerLoad.info("Updated Program Name is " + name);
			common.click(savePrgmBtn);
			
		}else if(string.equalsIgnoreCase("description")) {
			common.randomCheckboxSelection(editPrgmDescInput);
			common.sendKeys(editPrgmDescInput, "editdescwaituntilvisible");

			common.click(savePrgmBtn);	
			
		}else {
			common.click(inActiveStatusCheckbox);
			common.click(savePrgmBtn);	
		}
	}
	
	public boolean isSuccessMsgDisplayedForEdit() {
		String actualResult = common.getText(successMsgAddPrgm);
		if (actualResult.contains("Program Updated")) {
	    return true;}
		return false;
	}
	
	public void deleteBtnClick() {
		common.click(deleteProgramBtn);
	}
	
	public boolean isDeleteConfirmPopupDisplayed() {
		return common.isDisplayed(deleteConfirmPopup);
	}
	
	public void yesBtnClick() {
		common.click(deleteConfirmPopupYesBtn);
	}
	
	public void noBtnClick() {
		common.click(deleteConfirmPopupNoBtn);
	}
	
	public boolean isDeleteMsgDisplayed() {
		String actualResult = common.getText(successMsgAddPrgm);
		if (actualResult.contains("Deleted")) {
	    return true;}
		return false;
	}
	
	public String selectedPrgmNameForDelete() {
		common.waitForPresence(searchedPrgmName);
		String name = driver.findElement(searchedPrgmName).getText();
		LoggerLoad.info("Selected Program for delete :" + name);
		return name;
	}
	
	public boolean isDeletedProgramVisible() {
	    return common.isDisplayed(zeroPrgmSearchResultMsg);
	}
	
	public boolean isPrgmDeleteFormDisappers() {
		String overlayVisible = driver.findElement(prgmDetailsVisible).getAttribute("ng-reflect-modal");
		return overlayVisible.equalsIgnoreCase("false");
	}
	
	public void deletePrgmConfirmCrossMarkBtnClick() {
		common.click(deleteCrossMarkConfirmBtn);
	}
	
	public void selectMultipleProgramCheckboxes() {
	    List<WebElement> checkboxes = driver.findElements(bodyCheckboxes);
	    if (checkboxes.size() < 2) {
	        throw new IllegalStateException("Less than two program checkboxes are available.");
	    }

	    int selectedCount = 0;

	    for (WebElement checkbox : checkboxes) {
	        if (!"true".equalsIgnoreCase(checkbox.getAttribute("aria-checked"))) {
	            checkbox.click();
	            selectedCount++;
	            if (selectedCount == 2) {
	                break;
	            }
	        }
	    }

	    if (selectedCount < 2) {
	        throw new IllegalStateException("Unable to select two program checkboxes.");
	    }

	    LoggerLoad.info("Two program checkboxes selected successfully.");
	}
		
	public void tableColumnHeaderCheckboxClick() {
		common.click(tableColumnHeaderCheckbox);
	}
	
	
	public boolean isCreatedProgramVisible() {
	    return common.isDisplayed(onePrgmSearchResultMsg);
	}
	
	public boolean isDeleteConfirmPopupDisappears() {
		common.waitForElementToDisappear(deleteConfirmPopup);
		return common.isDisplayed(deleteConfirmPopup);
	}
	
}

