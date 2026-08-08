package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramPage2 {

    WebDriver driver;
    WebDriverWait wait;

    public ProgramPage2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By program = By.xpath("//*[text()='Program']");
    By search = By.xpath("//*[@placeholder='Search...']");
    By textp = By.xpath("//*[text()='Python']");
    By progde = By.xpath("//*[text()='Coding Details']");
    By progst = By.xpath("//tr[td[normalize-space()='Python']]/td[normalize-space()='Active']");
    By zeroent = By.xpath("//*[text()='1']");

    public void clickprogram() {
        wait.until(ExpectedConditions.elementToBeClickable(program)).click();
    }

    public void searchbox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search))
            .sendKeys("Python");
    }

    public void searchboxdes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search))
            .sendKeys("Coding Details");
    }
    public void searchboxnotex() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search))
            .sendKeys("Java Script");
    }
    public void searchboxpar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search))
            .sendKeys("Py");
    }

    public String searchp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textp))
                   .getText();
    }
    public String progdescriptxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(progde))
                   .getText();
    }
    public String progdestatustxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(progst))
                   .getText();
    }
    public String zeroentries() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(zeroent))
                   .getText();
    }
    public String searchtx() {
        return "Python";
    }
    public String progtxt() {
        return "Coding Details";
    }
    public String entries() {
        return "0";
    }
    public String progsttxt() {
        return "Active";
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
}