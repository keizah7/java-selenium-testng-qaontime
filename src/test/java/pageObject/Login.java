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

	public Login(WebDriver driver) {
		super(driver);
	}

	public void login(String userName, String password) {
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

	public WebElement getError() {
		return error;
	}

	public void setError(WebElement error) {
		this.error = error;
	}
}
