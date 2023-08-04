package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement LoginButton;

	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	private WebElement MobileNumber;

	@FindBy(xpath = "//button[text()='Request OTP' or text()='Continue']")
	private WebElement ContinueButton;

	@FindBy(xpath = "//button[text()='Request OTP' or text()='Continue']")
	private WebElement OTP;

	@FindBy(xpath = "//button[text()='Verify']")
	private WebElement VerifyButton;
	
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonLogin() {
		LoginButton.click();
	}

	public void ClickOnMobileNumber(String Mobile) {
		MobileNumber.click();
		MobileNumber.sendKeys(Mobile);
	}

	public void ClickOnContinueButton() {
		ContinueButton.click();
	}

	public void ClickOnOTP(String otp) {
		OTP.click();
		OTP.sendKeys(otp);
	}

	public void ClickOnVerify() {
		VerifyButton.click();
	}
}
