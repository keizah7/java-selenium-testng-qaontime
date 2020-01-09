package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.Login;

public class LoginTest {
	public WebDriver driver;
	Login auth;
	private String loginCookieName = "WebIssuesSID";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		auth = new Login(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void Should_BeNotAbleToLogin_When_ProvidingInvalidUserName() throws InterruptedException {
		auth.login("invalid", "murashka.arturas@gmail.com");

		Assert.assertEquals(auth.getError().getText(), "Incorrect value: Invalid login or password.",
				"Validation message is missing");
	}

	@Test
	public void Should_BeNotAbleToLogin_When_ProvidingInvalidPassword() throws InterruptedException {
		auth.login("murashka.arturas@gmail.com", "invalida");

		Assert.assertEquals(auth.getError().getText(), "Incorrect value: Invalid login or password.",
				"Validation message is missing");
	}
	
	@Test
	public void Should_BeAbleToLogin_When_WithValidData() throws InterruptedException {
		auth.login("murashka.arturas@gmail.com", "murashka.arturas@gmail.com");
		boolean cookie = driver.manage().getCookieNamed(loginCookieName) != null;
		
		Assert.assertTrue(cookie, "Login failed");
	}
	
	@Test
	public void Should_BeAbleToLogOut_When_PressLink() throws InterruptedException {
		auth.login("murashka.arturas@gmail.com", "murashka.arturas@gmail.com");
		auth.logout();

		boolean cookie = driver.manage().getCookieNamed(loginCookieName) == null;
		
		Assert.assertTrue(cookie, "LogOut failed");
	}
	
	@Test
	public void Should_BeAbleToLogOut_When_DeleteCookie() throws InterruptedException {
		auth.login("murashka.arturas@gmail.com", "murashka.arturas@gmail.com");
		
		driver.manage().deleteCookieNamed(loginCookieName);
		boolean cookie = driver.manage().getCookieNamed(loginCookieName) == null;
		
		Assert.assertTrue(cookie, "LogOut failed when deleting cookie manually");
	}
}
