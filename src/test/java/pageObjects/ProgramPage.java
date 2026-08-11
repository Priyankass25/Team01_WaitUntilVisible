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

import utilities.CommonMethods;

public class ProgramPage {

	WebDriver driver;
	CommonMethods common;
  WebDriverWait wait;


	public ProgramPage(WebDriver driver) {
		this.driver = driver;
		this.common = new CommonMethods(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
	
//sowmya
	 By textp = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr[1]/td[2]");
	 By progde = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr[1]/td[3]");
   By progst = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr[1]/td[4]");
   By zeroent = By.xpath("//*[text()='1']");
   By programname = By.xpath("//*[@psortablecolumn='programName']");
   By tablelist = By.xpath("//*[@class='p-datatable-wrapper ng-star-inserted']");
   By overlay = By.cssSelector("div.cdk-overlay-backdrop.cdk-overlay-backdrop-showing");
   By programdescription = By.xpath("//*[@psortablecolumn='programDescription']");
   By programstatus = By.xpath("//*[@psortablecolumn='programStatus']");
   By nextarrow = By.xpath("//*[@class='p-paginator-icon pi pi-angle-right']");
   By selectnumb=By.xpath("//*[text()='1']");
   By selectnumbr=By.xpath("//*[text()='2']");
   By lastarrow=By.xpath(" //*[@class='p-paginator-icon pi pi-angle-double-right']");
   By totalPrograms = By.xpath("//*[text()=' In total there are 99 programs. ']");
   By infototal= By.xpath("//*[@class='p-paginator-current ng-star-inserted']");
   By prearrow= By.xpath("//*[@ng-reflect-ng-class=\"p-paginator p-component\"]/button[2]");
   By firstarrow= By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[1]");
		 
		




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

	//searchTextBox
	 public void searchboxenter() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox))
           .sendKeys("Python");
   }
   public void searchboxdes() {
   wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox))
       .sendKeys("Coding Details");
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
wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox))
  .sendKeys("Java Script");
}
public String entries() {
return "0";
}
public String zeroentries() {
return wait.until(ExpectedConditions.visibilityOfElementLocated(zeroent))
         .getText();
}
public void searchboxpar() {
wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox))
  .sendKeys("Py");
}
public void clickprogramname() {
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

	    // Wait for sort icon and click
	    WebElement sortIcon = wait.until(
	            ExpectedConditions.elementToBeClickable(programname));

	    sortIcon.click();
	
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
  //  wait.until(ExpectedConditions.elementToBeClickable(programname)).click();
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
   String txt= wait.until(
        ExpectedConditions.visibilityOfElementLocated(selectnumb)
    ).getText().trim();
   int number = Integer.parseInt(txt);
   return String.valueOf(number);
}
public String getslectednumb() {
	   String txt= wait.until(
	        ExpectedConditions.visibilityOfElementLocated(selectnumbr)
	    ).getText().trim();
	   int number = Integer.parseInt(txt);
	   return String.valueOf(number);
	}
public String getafterarrowclk() {
    String text = wait.until(
        ExpectedConditions.visibilityOfElementLocated(selectnumb)
    ).getText().trim();

    int number = Integer.parseInt(text);

    return String.valueOf(number + 1);
}
public String getaprearrowclk() {
    String text = wait.until(
        ExpectedConditions.visibilityOfElementLocated(selectnumbr)
    ).getText().trim();

    int number = Integer.parseInt(text);

    return String.valueOf(number - 1);
}
public List<String> getProgramDescriptions() {

    List<WebElement> elements =
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tablelist));

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

    List<WebElement> elements =
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tablelist));

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

	String text = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(infototal)
	    ).getText().trim();

	    String[] numbers = text.replaceAll("[^0-9 ]", " ")
	                           .trim()
	                           .split("\\s+");

	    return Integer.parseInt(numbers[2]);
	
}
public int getDisplayedEntries() {

    String text = wait.until(
        ExpectedConditions.visibilityOfElementLocated(infototal)
    ).getText().trim();

    String[] numbers = text.replaceAll("[^0-9 ]", " ")
                           .trim()
                           .split("\\s+");

    return Integer.parseInt(numbers[1]);
}
public int getFirstNumber() {

    String text = wait.until(
        ExpectedConditions.visibilityOfElementLocated(infototal)
    ).getText().trim();

    String[] numbers = text.replaceAll("[^0-9 ]", " ")
                           .trim()
                           .split("\\s+");

    return Integer.parseInt(numbers[0]);
}

}