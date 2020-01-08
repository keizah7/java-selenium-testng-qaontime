package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddIssue extends PageObject {
	@FindBy(id = "field-issues-issueName")
	private WebElement issueField;

	@FindBy(id = "field-issues-descriptionText")
	private WebElement descriptionField;

	@FindBy(id = "field-issues-value4")
	private WebElement severityField;

	@FindBy(id = "field-issues-okSubmit")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"form-issues\"]/div/div[1]/p")
	private WebElement errorIssue;

	@FindBy(xpath = "//*[@id=\"form-issues\"]/div/div[2]/div[5]/p")
	private WebElement errorSeverity;

	public AddIssue(WebDriver driver) {
		super(driver);
	}

	public void add(String issue, String description) throws InterruptedException {
		driver.get("http://qaontime.com/register/client/index.php?folder=5");
		driver.findElement(By.linkText("Add Issue")).click();

		this.issueField.sendKeys(issue);
		this.descriptionField.sendKeys(description);
		Thread.sleep(1000);
		this.submitButton.click();
	}

	public void add(String issue, String description, String severity) {
		driver.get("http://qaontime.com/register/client/index.php?folder=5");
		driver.findElement(By.linkText("Add Issue")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.issueField.sendKeys(issue);
		this.descriptionField.sendKeys(description);
		this.severityField.sendKeys(severity);
		this.submitButton.click();
	}

	public void delete() {
		driver.findElement(By.linkText("Delete Issue")).click();
		driver.findElement(By.id("field-issues-okSubmit")).click();
	}

	public WebElement getErrorIssue() {
		return errorIssue;
	}

	public WebElement getErrorSeverity() {
		return errorSeverity;
	}
}
