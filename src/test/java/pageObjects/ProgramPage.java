package pageObjects;

import java.awt.Dimension;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonMethods;

public class ProgramPage {

	WebDriver driver;
	CommonMethods common;

	public ProgramPage(WebDriver driver) {
		this.driver = driver;
		this.common = new CommonMethods(driver);
	}
	
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
	public By prgmName = By.xpath("//div//label[text()='Name']");
	public By asteriskStatus = By.xpath("//lable[contains(text(), 'Status')]//span");
	public By prgmDesc = By.xpath("//div//label[text()='Description']");
	public By prgmStatus = By.xpath("//div//lable[text()='Status']");
	public By statusRadioBtns = By.xpath("//div//p-radiobutton");
	public By overlayBackdrop = By.cssSelector("div.cdk-overlay-backdrop.cdk-overlay-backdrop-showing");
	
	

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
		return driver.findElement(prgmName).isDisplayed();
	}
	
	public boolean isDescriptionTextBoxDisplayed() {
		return driver.findElement(prgmDesc).isDisplayed();
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
	

}
