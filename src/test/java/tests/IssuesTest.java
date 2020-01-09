package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pageObject.*;
import utils.Utils;

public class IssuesTest {
	public WebDriver driver;
	public AddIssue issue;

	@Test
	public void Should_BeAbleToCreateIssue_When_ProvidingCorrectData() throws InterruptedException  {
		String issueName = Utils.randomText(10) + Utils.randomInt(100, 999);
		
		issue.add(issueName, Utils.randomText(50));
		issue.delete();
	}

	@Test // (timeOut=1000) //(enabled=false)
	public void Should_NotBeAbleToCreateIssue_When_IssueNameIsNotProvided() throws InterruptedException {
		issue.add("", Utils.randomText(100));

		Assert.assertEquals(issue.getErrorIssue().getText(), "Incorrect value: Required value is missing.");
	}
	
	@Test // (timeOut=1000) //(enabled=false)
	public void Should_NotBeAbleToCreateIssue_When_IssueNameIsEmpty() throws InterruptedException {
		issue.add("", Utils.randomText(100));

		Assert.assertEquals(issue.getErrorIssue().getText(), "Incorrect value: Required value is missing.");
	}

	@Test
	public void Should_NotBeAbleToCreateIssue_When_IssueSeverityIsInvalid() throws InterruptedException {
		issue.add("random random", "severity", "30");

		Assert.assertEquals(issue.getErrorSeverity().getText(), "Incorrect value: Number is too big.");
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qaontime.com/register");

		Login auth = new Login(driver);
		auth.login("murashka.arturas@gmail.com", "murashka.arturas@gmail.com");
		
		issue = new AddIssue(driver);
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

//	@Test(expectedExceptions = ArithmeticException.class)
//	public void divideByZero() {
//		int i = 1/0;
//	}
}