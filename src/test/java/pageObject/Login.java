package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject {
	@FindBy(id = "field-login-login")
	private WebElement loginField;

	@FindBy(id = "field-login-password")
	private WebElement passField;

	@FindBy(id = "field-login-loginSubmit")
	private WebElement loginSubmitButton;

	@FindBy(className = "error")
	private WebElement error;
	
	@FindBy(linkText="Log Out")
	private WebElement logOutLink;

	public WebElement getLogOutLink() {
		return logOutLink;
	}

	public Login(WebDriver driver) {
		super(driver);
	}

	public void login(String userName, String password) {
		driver.get("http://qaontime.com/register");
		this.loginField.clear();
		this.passField.clear();
		
		this.loginField.sendKeys(userName);
		this.passField.sendKeys(password);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.loginSubmitButton.click();
	}
	
	public void logout() {
		logOutLink.click();
	}

	public WebElement getError() {
		return error;
	}

	public void setError(WebElement error) {
		this.error = error;
	}
}