package pageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import context.TestContextSetup;
import io.cucumber.datatable.DataTable;
import utilities.CommonMethods;
import utilities.ExcelUtils;
import utilities.ConfigReader;
import utilities.LoggerLoad;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BatchPage {
	private static Logger logger = LogManager.getLogger();

   // WebDriver driver;
    CommonMethods common;
    ExcelUtils excel;
    
        private WebDriver driver;

        

    public BatchPage(WebDriver driver){
        this.driver = driver;
       // this.common = new CommonMethods(driver);
        //this.excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
    }


	By nextPage = By.xpath("//button[contains(@class,'p-paginator-next')]");

    public By password=By.id("password");
    public By username=By.id("username");
    public By selectTheRole=By.xpath("//span[text()='Select the role']");
    public By Admin=By.xpath("//span[text()=' Admin ']");
    public By dropdownClose=By.tagName("body");
    private By Batch3 =
    	    By.xpath("//button[.//span[normalize-space()='Batch']]");

    	private By BatchManage1 =
    	    By.xpath("//*[normalize-space()='Manage Batch']");
    By allTextboxes = By.xpath("//div[@class='space-y-2']//input");
    By Batch1 =By.xpath("//button[@mat-button class=\'mat-focus-indicator mat-menu-trigger mat-button mat-button-base\']");
   // By Batch = By.xpath("//span[text()='Batch']");
    By BatchManage=By.xpath("//div[text()=' Manage Batch']");
    By AddBatch=By.xpath("//button[text()='Add New Batch']");
    By DeleteDIs=By.xpath("//button[@disabled and @icon='pi pi-trash']");
    By deleteButtonLocator = By.xpath(
	        "//button[contains(@class,'p-button-danger') " +
	        "and contains(@class,'p-button-icon-only') " +
	        "and .//span[contains(@class,'pi-trash')]]"
	    );
    By Edit=By.xpath("//span[@class='p-button-icon pi pi-pencil']");
    private By batchMenu = By.xpath("//button[.//span[normalize-space()='Batch']]");
    private By addNewBatch = By.xpath(
    	    "//button[@mat-menu-item and normalize-space()='Add New Batch']"
    	);
    private By addNewBatch1 = By.xpath(
        "//div[contains(@class,'mat-menu-panel')]//button[.//span[normalize-space()='Add New Batch']]"
    );
  
    private By confirmationDialog =
            By.cssSelector("div.p-confirm-dialog");

    private By noButton1 =
            By.cssSelector("button.p-confirm-dialog-reject");

    private By yesButton1 =
            By.cssSelector("button.p-confirm-dialog-accept");

    private By closeButton1 =
            By.cssSelector("button.p-dialog-header-close");
        private By deleteButton = By.xpath("//button[.//span[contains(@class,'pi-trash')]]");

        private By yesButton = By.xpath("//button[normalize-space()='Yes']");
        private By noButton = By.xpath("//button[normalize-space()='No']");
        private By closeButton = By.xpath("//button[contains(@class,'p-dialog-header-close')]");

        private By confirmationPopup = By.xpath(
            "//*[contains(@class,'p-dialog') or contains(@class,'mat-dialog-container')]"
        );

        private By successMessage = By.xpath(
            "//*[contains(@class,'p-toast-message-success')]"
        );
        By close=By.tagName("Body");
        private By batchPageHeader = By.xpath("//h1[contains(text(),'Batch')]"); // PrimeNG pagination
        private By pagination = By.cssSelector("div.p-paginator"); 
        private By firstPage = By.cssSelector("button.p-paginator-first"); 
        private By previousPage = By.cssSelector("button.p-paginator-prev");
        //private By nextPage = By.cssSelector("button.p-paginator-next");
        private By lastPage = By.cssSelector("button.p-paginator-last");

        private By multipleDeleteButton = By.xpath(
    		    "//button[contains(@class,'p-button-danger') " +
    		    "and contains(@class,'p-button-icon-only') " +
    		    "and not(contains(@class,'p-button-rounded')) " +
    		    "and .//span[contains(@class,'pi-trash')] " +
    		    "and not(@disabled)]"
    		);
        public void clickAddNewBatch1() {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(
                ExpectedConditions.elementToBeClickable(addNewBatch)
            ).click();
        }
        public boolean isFirstPageDisabled1() {
            return isDisabled(firstPage);
        }

        
            

        public boolean isPreviousPageDisabled() {
            return isDisabled(previousPage);
        }

        public boolean isNextPageDisabled() {
            return isDisabled(nextPage);
        }

        public boolean isLastPageDisabled() {
            return isDisabled(lastPage);
        }
        public void clickDeleteIcon2() {
            driver.findElement( deleteButton).click();
        }

        public boolean isConfirmationPopupDisplayed1() {
            return driver.findElement(confirmationPopup).isDisplayed();
        }

        public void clickYes() {
            driver.findElement(yesButton1).click();
        }

        public void clickNo() {
            driver.findElement(noButton1).click();
        }

        public void clickClose() {
            driver.findElement(closeButton1).click();
        }

        public boolean isSuccessMessageDisplayed() {
            return driver.findElement(successMessage).isDisplayed();
        }
        private By activePage = By.cssSelector("button.p-paginator-page.p-highlight"); 

    


    

    
    
    
    
    
   
    By sortIcons = By.cssSelector("thead.p-datatable-thead th i.p-sortable-column-icon");

    public void verifySortIcons() {
        List<WebElement> icons = driver.findElements(sortIcons);

        Assert.assertTrue(icons.size() > 0, "No sort icons are displayed");

        for (WebElement icon : icons) {
            Assert.assertTrue(
                icon.isDisplayed(),
                "Sort icon is not displayed"
            );
        }

        System.out.println("Total sort icons displayed: " + icons.size());
    }
    public void verifyAddNewBatchField(String field) {

        By locator;

        switch (field) {

        case "Batch Name field":
            locator = By.xpath("//input[@placeholder='Batch Name']");
            break;

        case "Number of Classes field":
            locator = By.xpath("//input[@placeholder='Number of Classes']");
            break;

        case "Description field":
            locator = By.xpath("//textarea");
            break;

        case "Program Name dropdown":
            locator = By.xpath("//p-dropdown");
            break;

        case "Status radio buttons":
            locator = By.xpath("//p-radiobutton");
            break;

        default:
            throw new IllegalArgumentException("Unknown field: " + field);
        }

        WebElement element = driver.findElement(locator);

        Assert.assertTrue(
            element.isDisplayed(),
            field + " is not displayed"
        );

        System.out.println(field + " is displayed");
    }
    
    public void batchSelect() {
    WebDriver driver = TestContextSetup.getDriver();
  	

    driver.findElement(
        By.xpath("//button[.//span[normalize-space()='Batch']]")
    ).click();
String actualHeading = driver.findElement(Batch3).getText();
	

    String expectedHeading = "Batch";

    Assert.assertEquals(
            actualHeading,
            expectedHeading,
            "Batch page is not displayed"
    );
}
    public void username1() {
    	//driver.findElement(username).clear();
    	//driver.findElement(username).sendKeys("Lmshackathon@gmail.com");
    	

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	    WebElement user = wait.until(
    	        ExpectedConditions.elementToBeClickable(username)
    	    );

    	    user.click();
    	    user.clear();
    	    user.sendKeys("Lmshackathon@gmail.com");

    	    System.out.println("Username entered: "
    	            + user.getAttribute("value"));
    	}
    	
    
    public void password2() {
    	//driver.findElement(password).clear();
    	//driver.findElement(password).sendKeys("lmsAug@2026");

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	    WebElement pass = wait.until(
    	        ExpectedConditions.elementToBeClickable(password)
    	    );

    	    pass.click();
    	    pass.clear();
    	    pass.sendKeys("lmsAug@2026");

    	    System.out.println("Password entered: "
    	            + pass.getAttribute("value"));
    	}
    
    public void Role() {
    	driver.findElement(selectTheRole).click();
    	driver.findElement(Admin).click();
    	driver.findElement(dropdownClose).click();
    }
    public void DeleteEN_DIS() {
		 WebDriver driver = TestContextSetup.getDriver();

    	//driver.findElement(DeleteDIs).click();
    	


    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	   /* By deleteButtonLocator = By.xpath(
    	        "//button[contains(@class,'p-button-danger') " +
    	        "and contains(@class,'p-button-icon-only') " +
    	        "and .//span[contains(@class,'pi-trash')]]"
    	    );*/

    	    WebElement deleteButton = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(deleteButtonLocator)
    	    );

    	    Assert.assertTrue(
    	        deleteButton.isDisplayed(),
    	        "Delete icon is not displayed"
    	    );

    	    Assert.assertFalse(
    	        deleteButton.isEnabled(),
    	        "Delete button should be disabled before selecting batches"
    	    );
    	}
    
    public void TitleBatch(String Batch) {
    	driver.findElement(Batch3).click();
    	//driver.findElement(BatchManage).click();
    	String actualHeading = driver.findElement(Batch3).getText();
    	

        String expectedHeading = " Manage Batch";

        Assert.assertEquals(
                actualHeading,
                expectedHeading,
                "Manage Batch page is not displayed"
        );
    }
    	//driver.findElement(BatchManage).click();
   

        public void TitleBatch1(String batch) {

            WebDriver driver = TestContextSetup.getDriver();
          	

            driver.findElement(
                By.xpath("//button[.//span[normalize-space()='Batch']]")
            ).click();
            
String actualHeading = driver.findElement(Batch3).getText();
        	

            String expectedHeading = "Batch";

            Assert.assertEquals(
                    actualHeading,
                    expectedHeading,
                    "Batch page is not displayed"
            );
        }
      
        public void TitleManageBatch() {

            WebDriver driver = TestContextSetup.getDriver();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement manageBatch = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[normalize-space()='Manage Batch']")
                )
            );

            String actualHeading = manageBatch.getText().trim();
            String expectedHeading = "Manage Batch";

            Assert.assertEquals(
                actualHeading,
                expectedHeading,
                "Manage Batch page is not displayed"
            );
        }

        public void AddNewBatch() {
            WebDriver driver = TestContextSetup.getDriver();

        	driver.findElement(Batch3).click();
        	WebElement Add=driver.findElement(addNewBatch);
        	Add.click();
        	String actualHeading = Add.getText().trim();
            String expectedHeading = "Add New Batch";

            Assert.assertEquals(
                actualHeading,
                expectedHeading,
                "Manage Batch page is not displayed"
            );
        }
       
        public void Addassertions(String addNewBatch) {
        	 WebDriver driver = TestContextSetup.getDriver();

             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

             WebElement submenu = wait.until(
                 ExpectedConditions.visibilityOfElementLocated(
                     By.xpath("//*[normalize-space()='" + addNewBatch + "']")
                 )
             );

             Assert.assertTrue(
                 submenu.isDisplayed(),
                 addNewBatch + " submenu option is not displayed"
             );

             System.out.println(
                 "PASS: " + addNewBatch + " submenu option is displayed"
             );
            // Batch.AddNewBatch();
        }     
 		public void DeleteDisable(){
 			 WebDriver driver = TestContextSetup.getDriver();

 		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 		    WebElement deleteButton = wait.until(
 		        ExpectedConditions.visibilityOfElementLocated(
 		            By.xpath("//button[@disabled and .//*[contains(@class,'delete')]]")
 		        )
 		    );
 		}
 		    public void TitleBatchAll() {

 	            WebDriver driver = TestContextSetup.getDriver();
 	          	

 	            driver.findElement(
 	                By.xpath("//button[.//span[normalize-space()='Batch']]")
 	            ).click();
 	           driver.findElement(close).click();
 	            
 		    }
 		   public void DeleteDisable1() {

 			    WebDriver driver = TestContextSetup.getDriver();

 			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 			    By deleteButton = By.cssSelector(
 			        "button.p-button-danger.p-button-icon-only"
 			    );

 			    WebElement button = wait.until(
 			        ExpectedConditions.presenceOfElementLocated(deleteButton)
 			    );

 			    Assert.assertTrue(
 			        button.isDisplayed(),
 			        "Delete icon is not displayed"
 			    );
 			   logger.info("PASS: Delete icon is displayed");

 			    Assert.assertFalse(
 			        button.isEnabled(),
 			        "Delete button should be disabled before selecting batches its disabled"
 			    );
 			   logger.info("PASS: Delete button is disabled before selecting batches its disabled");

 			}
 		  public void verifyPaginationControls() {
    
 			    WebDriver driver = TestContextSetup.getDriver();

 			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 			    WebElement paginator = wait.until(
 			        ExpectedConditions.visibilityOfElementLocated(
 			            By.cssSelector("p-paginator .p-paginator")
 			        )
 			    );
 			   JavascriptExecutor js = (JavascriptExecutor) driver;
 			  js.executeScript("arguments[0].scrollIntoView(true);", paginator);
 			    Assert.assertTrue(
 			        paginator.isDisplayed(),
 			        "Pagination controls are displayed below the data table"
 			    );
 			    logger.info("Pagination controls are displayed below the data table");

 			}
 		
 			
 				public void EditBatch() {

 				    WebDriver driver = TestContextSetup.getDriver();

 				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 				    // Close the open Angular Material menu
 				    List<WebElement> backdrop = driver.findElements(
 				        By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
 				    );

 				    if (!backdrop.isEmpty()) {
 				        new Actions(driver)
 				            .sendKeys(Keys.ESCAPE)
 				            .perform();

 				        wait.until(ExpectedConditions.invisibilityOfElementLocated(
 				            By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
 				        ));
 				    }

 				    // Now click Edit
 				    By editButton = By.xpath(
 				        "//button[.//span[contains(@class,'pi-pencil')]]"
 				    );

 				    WebElement edit = wait.until(
 				        ExpectedConditions.elementToBeClickable(editButton)
 				    );

 				    edit.click();
 				}
 		
public void verifyDeleteButton() {

    WebDriver driver = TestContextSetup.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement deleteButton = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//button[contains(@class,'p-button-danger') and .//span[contains(@class,'pi-trash')]]")
        )
    );

    boolean isDisplayed = deleteButton.isDisplayed();

    Assert.assertTrue(
        isDisplayed,
        "Delete button is not displayed"
    );

    if (isDisplayed) {
        System.out.println("PASS: Delete button is displayed");
    }
}
public void verifyBatchCheckbox() {

    WebDriver driver = TestContextSetup.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement checkbox = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@role='checkbox' and contains(@class,'p-checkbox-box')]")
        )
    );

    Assert.assertTrue(
        checkbox.isDisplayed(),
        "Checkbox is not displayed"
    );

    System.out.println("PASS: Checkbox is displayed");
}
public void verifyBatchTableHeaders(List<String> expectedHeaders) {
    WebDriver driver = TestContextSetup.getDriver();

    List<WebElement> headers = driver.findElements(
        By.cssSelector("thead.p-datatable-thead th")
    );

    for (String expectedHeader : expectedHeaders) {

        boolean found = false;

        for (WebElement header : headers) {

            if (header.getText().trim().equals(expectedHeader)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(
            found,
            "Header is not displayed: " + expectedHeader
        );

        if (found) {
            System.out.println(
                "PASS: Header displayed - " + expectedHeader
            );
        }
    }
}



	public void clickAddNewBatch() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Open Batch menu
	    WebElement batchMenu = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[.//span[normalize-space()='Batch']]")
	        )
	    );
	    batchMenu.click();

	    // Click Add New Batch from the opened menu
	    WebElement addNewBatch = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//*[contains(normalize-space(.),'Add New Batch')]")
	        )
	    );

	    addNewBatch.click();
	}
	public void clickDeleteIcon1() {
		    WebDriver driver = TestContextSetup.getDriver();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Close the open Angular Material menu
		    List<WebElement> backdrop = driver.findElements(
		        By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
		    );

		    if (!backdrop.isEmpty()) {
		        new Actions(driver)
		            .sendKeys(Keys.ESCAPE)
		            .perform();

		        wait.until(ExpectedConditions.invisibilityOfElementLocated(
		            By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
		        ));

	    // Now click delete
	    WebElement deleteButton = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//button[contains(@class,'p-button-danger') and .//span[contains(@class,'pi-trash')]]")
	            )
	        );

	    deleteButton.click();
	}}
	
	public void clickDeleteIcon() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement deleteButton = wait.until(
	        ExpectedConditions.elementToBeClickable(
	        		 deleteButtonLocator)
	        )
	    ;

	    deleteButton.click();
	}

	public boolean isConfirmationPopupDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    return wait.until(
	        ExpectedConditions.visibilityOfElementLocated(confirmationDialog)
	    ).isDisplayed();
	}

	public void clickYes1() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	        ExpectedConditions.elementToBeClickable(yesButton)
	    ).click();
	}

	public void clickNo1() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	        ExpectedConditions.elementToBeClickable(noButton)
	    ).click();
	}

	public void clickClose1() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	        ExpectedConditions.elementToBeClickable(closeButton)
	    ).click();
	}public void clickDeleteIcon4() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement delete = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//button[.//span[contains(@class,'pi-trash')]]")
	        )
	    );

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block:'center'});", delete
	    );

	    wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
	}
	
	private By firstRowDelete = By.xpath(
		    "(//tbody//button[.//span[contains(@class,'pi-trash')]])[1]"
		);

		public void clickDeleteIcon5() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    WebElement delete = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(firstRowDelete)
		    );

		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block:'center'});", delete
		    );

		    wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
		}
		
		private By deleteButton10 = By.xpath(
			    "//button[contains(@class,'p-button-danger') and .//span[contains(@class,'pi-trash')] ]"
			);

			private By overlay = By.cssSelector(
			    ".cdk-overlay-backdrop"
			);

			public void clickDeleteIcon10() {

			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    // Wait until any previous Angular/Material overlay disappears
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

			    // Find an enabled delete button
			    WebElement delete = wait.until(
			        ExpectedConditions.elementToBeClickable(deleteButton)
			    );

			    delete.click();
			}
			private By enabledDeleteButton = By.xpath(
				    "//button[contains(@class,'p-button-danger') " +
				    "and not(@disabled) " +
				    "and .//span[contains(@class,'pi-trash')]]"
				);
			

				private By deleteButton2 = By.xpath(
					    "//button[contains(@class,'p-button-danger') " +
					    "and not(@disabled) " +
					    "and .//span[contains(@class,'pi-trash')]"
					);

					private By overlay1 = By.cssSelector(
					    "div.cdk-overlay-backdrop.cdk-overlay-backdrop-showing"
					);

					public void clickDeleteIcon9() {

					    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    // If overlay is present, click it to close it
					    List<WebElement> overlays = driver.findElements(overlay);

					    if (!overlays.isEmpty()) {
					        overlays.get(0).click();

					        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
					    }

					    // Now click Delete
					    WebElement delete = wait.until(
					        ExpectedConditions.elementToBeClickable(deleteButton)
					    );

					    delete.click();
					}
					public void clickDeleteIconD() {

					    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    By deleteButton = By.xpath(
					        "//button[contains(@class,'p-button-danger') " +
					        "and .//span[contains(@class,'pi-trash')]"
					    );

					    List<WebElement> buttons = driver.findElements(deleteButton);

					    System.out.println("Delete buttons found: " + buttons.size());

					    for (WebElement button : buttons) {
					        System.out.println("Displayed: " + button.isDisplayed());
					        System.out.println("Enabled: " + button.isEnabled());
					        System.out.println("HTML: " + button.getAttribute("outerHTML"));
					    }}
					    public void clickTrash() {
					    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

						    By deleteButton4 = By.xpath(
						        "//button[contains(@class,'p-button-danger') " +
						        "and .//span[contains(@class,'pi-trash')]"
						    );
						    driver.findElement(deleteButton4).click();
						    
					    }
					    public void doubleClickDeleteButton() {

					        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        By deleteButton = By.xpath(
					            "//button[contains(@class,'p-button-danger') " +
					            "and .//span[contains(@class,'pi-trash')]]"
					        );

					        WebElement delete = wait.until(
					            ExpectedConditions.elementToBeClickable(deleteButton)
					        );
					        delete.click();

					       // new Actions(driver)
					        //    .doubleClick(delete)
					        //    .perform();
					    }
					    public void clickDeleteIcon0() {

					        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        By deleteButton = By.xpath(
					            "//button[contains(@class,'p-button-danger') " +
					            "and contains(@class,'p-button-icon-only') " +
					            "and not(@disabled) " +
					            "and .//span[contains(@class,'pi-trash')]]"
					        );

					        WebElement delete = wait.until(
					            ExpectedConditions.elementToBeClickable(deleteButton)
					        );

					        delete.click();

					        By confirmationPopup = By.xpath(
					            "//div[contains(@class,'p-confirm-dialog')]"
					        );

					        wait.until(
					            ExpectedConditions.visibilityOfElementLocated(confirmationPopup)
					        );
					    }
					    private By batchCheckboxes = By.xpath(
					    	    "//div[@role='checkbox' and contains(@class,'p-checkbox-box') and @aria-checked='false']"
					    	);

					    	public void selectMultipleBatches() {

					    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    	    List<WebElement> checkboxes = wait.until(
					    	        ExpectedConditions.visibilityOfAllElementsLocatedBy(batchCheckboxes)
					    	    );

					    	    if (checkboxes.size() < 2) {
					    	        throw new RuntimeException("Less than 2 unchecked batch checkboxes found");
					    	    }

					    	    checkboxes.get(0).click();
					    	    checkboxes.get(1).click();
					    	}
					    	public boolean areMultipleBatchesSelected() {

					    	    By selectedCheckboxes = By.xpath(
					    	        "//div[@role='checkbox' and @aria-checked='true']"
					    	    );

					    	    return driver.findElements(selectedCheckboxes).size() >= 2;
					    	}
					    	public void multipleDelete() {
					    		driver.findElement(multipleDeleteButton).click();
					    		
					    	

					    	}
					    	public boolean isDeleteConfirmationDialogDisplayed() {
					    	    try {
					    	        return new WebDriverWait(driver, Duration.ofSeconds(10))
					    	                .until(ExpectedConditions.visibilityOfElementLocated(confirmationDialog))
					    	                .isDisplayed();
					    	    } catch (TimeoutException e) {
					    	        return false;
					    	    }
					    	}
					    	public void clickNextPage() {
					    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    	    wait.until(ExpectedConditions.elementToBeClickable(nextPage)).click();
					    	}
					    	public boolean isNextPageDisplayed() { 
					    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    		WebElement activePage = wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector("button.p-paginator-page.p-highlight") ) );
					   
					    	return activePage.getText().equals("2"); 
					    	}
					    	
					    	public void clicklastPage() {
					    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    	    wait.until(ExpectedConditions.elementToBeClickable(lastPage)).click();
					    	}
					    	public String isLastPageDisplayed() { 
					    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    		WebElement activePage = wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector("button.p-paginator-page.p-highlight") ) );
					    		String pageText = activePage.getText();

					    	    System.out.println("Active page: " + pageText);

					    	return activePage.getText(); 
					    	}
					    	public void clickFIRSTPage() {
					    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    	    wait.until(ExpectedConditions.elementToBeClickable(firstPage)).click();
					    	}
					    	
					    	public void clickprevPage() {
					    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					    	    wait.until(ExpectedConditions.elementToBeClickable(previousPage)).click();
					    	}
					    	
					   public String getActivePageNumber() { 
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

						   WebElement page = wait.until( ExpectedConditions.visibilityOfElementLocated(activePage) );
						   return page.getText().trim(); 
						   }
					   public boolean isFirstPageDisplayed() { 
						   return getActivePageNumber().equals("1"); 
						   }
					   
					   public boolean isBatchPageDisplayed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

						    return wait.until(
						        ExpectedConditions.visibilityOfElementLocated(BatchManage)
						    ).isDisplayed();
						}
					   private boolean isDisabled(By locator) {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

						    WebElement element = wait.until(
						        ExpectedConditions.visibilityOfElementLocated(locator)
						    );

						    return element.getAttribute("class").contains("p-disabled");
						}
					   public void isFirstPageDisabled() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

						    WebElement firstButton = wait.until(
						        ExpectedConditions.visibilityOfElementLocated(firstPage)
						    );

						    
						}
					   
					  // private By batchMenu =
					        //    By.xpath("//*[normalize-space()='Batch']");

					    //private By addNewBatch =
					      //      By.xpath("//*[normalize-space()='Add New Batch']");

					    private By batchNameField =
					            By.xpath("//input[contains(@placeholder,'Batch Name')]");

					    private By numberOfClassesField =
					            By.xpath("//input[contains(@placeholder,'Number of Classes')]");

					    private By descriptionField =
					            By.xpath("//textarea[contains(@placeholder,'Description')]");

					    private By programDropdown =
					            By.xpath("//mat-select");

					    private By statusRadioButtons =
					            By.xpath("//input[@type='radio']");

					    private By saveButton =
					            By.xpath("//button[normalize-space()='Save']");

					    private By cancelButton =
					            By.xpath("//button[normalize-space()='Cancel']");

					    private By closeButton2 =
					            By.xpath("//button[contains(@aria-label,'close') or contains(@class,'close')]");

					    private By successMessage1 =
					            By.xpath("//*[contains(text(),'success') or contains(text(),'Success')]");

					    private By mandatoryError =
					            By.xpath("//mat-error[@role='alert']");

					    private By batchNameSuffixError =
					            By.xpath("//mat-error[@role='alert']");

					    private By batchDetailsPopup =
					            By.xpath("//mat-dialog-container");


					    // ---------------- BATCH MENU ----------------

					  


					    // ---------------- VERIFY FIELDS ----------------

					    public boolean isBatchNameDisplayed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        batchNameField
					                )
					        ).isDisplayed();
					    }


					    public boolean isNumberOfClassesDisplayed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        numberOfClassesField
					                )
					        ).isDisplayed();
					    }


					    public boolean isDescriptionDisplayed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        descriptionField
					                )
					        ).isDisplayed();
					    }


					    public boolean isProgramDropdownDisplayed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        programDropdown
					                )
					        ).isDisplayed();
					    }


					    public boolean isStatusRadioButtonsDisplayed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        statusRadioButtons
					                )
					        ).isDisplayed();
					    }


					    // ---------------- PROGRAM ----------------

					    public void selectProgram(String programName) {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        wait.until(
					                ExpectedConditions.elementToBeClickable(
					                        programDropdown
					                )
					        ).click();

					        By programOption = By.xpath(
					                "//mat-option//span[normalize-space()='"
					                        + programName +
					                        "']"
					        );

					        wait.until(
					                ExpectedConditions.elementToBeClickable(
					                        programOption
					                )
					        ).click();
					    }


					    public boolean isProgramNameDisplayedAsPrefix(String programName) {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        String value = wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        batchNameField
					                )
					        ).getAttribute("value");

					        return value != null && value.startsWith(programName);
					    }


					    // ---------------- BATCH NAME ----------------

					    public void enterBatchNameSuffix(String value) {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        batchNameField
					                )
					        ).sendKeys(value);
					    }


					    public boolean isBatchNameSuffixErrorDisplayed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        batchNameSuffixError
					                )
					        ).isDisplayed();
					    }


					    public void enterBatchNamePrefix(String value) {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        batchNameField
					                )
					        ).sendKeys(value);
					    }


					    public boolean isBatchNamePrefixEmpty() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        String value = wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        batchNameField
					                )
					        ).getAttribute("value");

					        return value == null || value.trim().isEmpty();
					    }


					    // ---------------- VALID DATA ----------------

					    public void enterValidBatchData(
					            String batchName,
					            String numberOfClasses,
					            String description,
					            String program) {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        batchNameField
					                )
					        ).sendKeys(batchName);

					        wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        numberOfClassesField
					                )
					        ).sendKeys(numberOfClasses);

					        wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        descriptionField
					                )
					        ).sendKeys(description);

					        selectProgram(program);
					    }


					    // ---------------- SAVE ----------------

					    public void clickSave() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        wait.until(
					                ExpectedConditions.elementToBeClickable(
					                        saveButton
					                )
					        ).click();
					    }


					    public boolean isSuccessMessageDisplayed3() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        successMessage
					                )
					        ).isDisplayed();
					    }


					    // ---------------- MANDATORY ERROR ----------------

					    public boolean isMandatoryErrorDisplayed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.visibilityOfElementLocated(
					                        mandatoryError
					                )
					        ).isDisplayed();
					    }


					    // ---------------- CANCEL ----------------

					    public void clickCancel() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        wait.until(
					                ExpectedConditions.elementToBeClickable(
					                        cancelButton
					                )
					        ).click();
					    }


					    // ---------------- CLOSE ----------------

					    public void clickCloseADD() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        wait.until(
					                ExpectedConditions.elementToBeClickable(
					                        closeButton
					                )
					        ).click();
					    }


					    public boolean isBatchDetailsPopupClosed() {
				    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					        return wait.until(
					                ExpectedConditions.invisibilityOfElementLocated(
					                        batchDetailsPopup
					                )
					        );
					    }
					}
					
					



	

	
 		
 	    
      
    
    


    

