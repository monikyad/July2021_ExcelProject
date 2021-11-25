package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {
	WebDriver driver;
ExcelReader exlRead = new ExcelReader("testData\\TF_TestData.xlsx");
	// Test Data
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String Phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	
    @Test
	public void validUserShoudBeAbleToAddCustomer() {
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.insertUserName("demo@techfios.com");
		login.insertPassword("abc123");
		login.clickSignInButton();
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);

		dashboard.verifyDashboard();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();

		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(company);
		addContactPage.insertEmail(email);
		addContactPage.insertPhone(Phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.selectCountry(country);
		addContactPage.insertZip(zip);
		addContactPage.clickOnSubmitButton();
		addContactPage.verifyProfilePage();
		
		dashboard.clickListCustomerButton();
		
		addContactPage.verifyEnteredNameAndDelete();
		
	}
}
