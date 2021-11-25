package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
		// storing element by using By class
		By userNameField = By.xpath("//input[@id='username']");
		By PasswordField = By.xpath("//input[@id='password']");
		By signInButtonField = By.xpath("/html/body/div/div/div/form/div[3]/button");
		
		@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USERNAME_ELEMENT;
		@FindBy(how= How.XPATH, using = "//input[@id='password']")WebElement PASSWORD_ELEMENT;
		@FindBy(how= How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")WebElement SIGNIN_BUTTON_ELEMENT;
		
		//Individual Method		
				public void insertUserName(String userName) {
					USERNAME_ELEMENT.sendKeys(userName);
				}
				public void insertPassword(String password) {              //writing method individually is easy to find the errors and fix them
					PASSWORD_ELEMENT.sendKeys(password);
				}
				public void clickSignInButton() {
					SIGNIN_BUTTON_ELEMENT.click();
				}
				
				//together
				
				public void loginTest(String userName, String password) {
					USERNAME_ELEMENT.sendKeys(userName);
					PASSWORD_ELEMENT.sendKeys(password);
					SIGNIN_BUTTON_ELEMENT.click();
				}
}
