package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentCheckoutPage {
	public WebDriver driver;

	public PaymentCheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='email']")
	private WebElement txt_Email;
	@FindBy(xpath = "(//span[contains(text(),'Continue')])[1]")
	private WebElement btn_Continue;
	@FindBy(xpath = "//*[text()='Edit']")
	private WebElement icon_edit;
	@FindBy(xpath = "//*[@name='firstName']")
	private WebElement txt_FirstName;
	@FindBy(xpath = "//*[@name='lastName']")
	private WebElement txt_LastName;
	@FindBy(xpath = "//*[@name='telephone']")
	private WebElement txt_PhoneNumber;
	@FindBy(xpath = "//*[@name='countryCode']")
	private WebElement drpdwn_Country;
	@FindBy(xpath = "//*[@name='addressLine1']")
	private WebElement txt_AddressLine1;
	@FindBy(xpath = "//*[@name='regionCode']")
	private WebElement drpdwn_Region;
	@FindBy(xpath = "//*[@name='postcode']")
	private WebElement txt_PostCode;
	@FindBy(xpath = "//*[@name='city']")
	private WebElement txt_City;
	@FindBy(css = "div[class='mt-16 flex flex-col-reverse gap-8 sm:flex-row sm:gap-12'] span[class='type-body-sm z-10']")
	private WebElement btn_Delivery_SubmittoContinue;

	@FindBy(css = "button[type='button'] span[class='type-body-sm z-10']")
	private WebElement btn_Billing_SubmitToContinue;

	@FindBy(xpath = "//span[normalize-space()='Submit to Continue']")
	private WebElement btn_DeliveryMethod_SubmitToContinue;

	@FindBy(xpath = "//input[@aria-label='Card number']")
	private WebElement txt_CardNumber;
	@FindBy(xpath = "//input[@aria-label='Expiry date']")
	private WebElement txt_Expirydate;
	@FindBy(xpath = "//input[@aria-label='Security code']")
	private WebElement txt_SecurityCode;
	@FindBy(xpath = "//input[@name='holderName']")
	private WebElement txt_NameOnCard;
	@FindBy(xpath = "//*[@class='adyen-checkout__button__text']")
	private WebElement btn_Pay;

	@FindBy(xpath = "//*[@id='primary']")
	private WebElement btn_gpay;

	@FindBy(xpath = "//*[@class='type-body-headline-sm']")
	private WebElement msg_OrderConfirm;
	@FindBy(xpath = "//*[@name='answer']")
	private WebElement txt_passwordforCard;
	@FindBy(xpath = "//button[@id='buttonSubmit']")
	private WebElement btn_OKafterpassword;
	@FindBy(xpath = "//div[@class='flex justify-between pb-7 pt-7']")
	private WebElement alert_declinedPayment;

	public void enterEmailOnEmailField(String email) {
		txt_Email.click();
		txt_Email.sendKeys(email);
	}

	public void clickOnContinueButtonAfterEmail() {
		btn_Continue.click();
	}

	public void enterFirstNameOnNameField() {
		if (icon_edit.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click", txt_FirstName);
			js.executeScript("arguments[0].value='Na1';", txt_FirstName);
		}
	}

	public void enterLastNameOnNameField() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_LastName);
		js.executeScript("arguments[0].value='N2';", txt_LastName);
	}

	public void enterPhoneNumber() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_PhoneNumber);
		js.executeScript("arguments[0].value='9876543210';", txt_PhoneNumber);
	}

	public void selectCountryName() {
		Select countrydrpdwn = new Select(drpdwn_Country);
		countrydrpdwn.selectByValue("GB");
	}

	public void enterAddressOnAddressLine1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_AddressLine1);
		js.executeScript("arguments[0].value='stratford1';", txt_AddressLine1);
	}

	public void selectRegion() {
		Select selectregion = new Select(drpdwn_Region);
		selectregion.selectByValue("GB-SCT");
	}

	public void enterPostCode() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_PostCode);
		js.executeScript("arguments[0].value='E112RS';", txt_PostCode);
	}

	public void enterCity() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_City);
		js.executeScript("arguments[0].value='StartFordCentre';", txt_City);
	}

	public void click_submittocontinuebtnafterEnteringCustomerDetails() {
		Actions act = new Actions(driver);
		for (int i = 0; i <= 6; i++) {
			act.moveToElement(btn_DeliveryMethod_SubmitToContinue).click().perform();
		}
	}

	public void click_toConfirmBillingAddressSameasDeliveryAddress() throws InterruptedException {
		Thread.sleep(2000);
		btn_Billing_SubmitToContinue.click();
		// Actions act=new Actions(driver);
		// act.moveToElement(btn_Billing_SubmitToContinue).click().perform();
	}

	public void click_submittoContinueforDeliveryMethod() throws InterruptedException {
		// Thread.sleep(2000);
		btn_DeliveryMethod_SubmitToContinue.click();
	}

	public void enterCardNumber(String cardnumber) {
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@class='js-iframe' and @title='Iframe for card number']")));
		txt_CardNumber.sendKeys(cardnumber);
		driver.switchTo().defaultContent();
	}

	public void enterExpiryDate(String date) {
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@class='js-iframe' and @title='Iframe for expiry date']")));
		txt_Expirydate.sendKeys(date);
		driver.switchTo().defaultContent();
	}

	public void enterSecurityCode(String securitycode) {
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@class='js-iframe' and @title='Iframe for security code']")));
		txt_SecurityCode.sendKeys(securitycode);
		driver.switchTo().defaultContent();
	}

	public void enterNameOnCard() throws InterruptedException {
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(txt_NameOnCard).click().sendKeys("Rinu").perform();

	}

	public void clickOnPayButton() {
		Actions act = new Actions(driver);
		act.moveToElement(btn_Pay).click(btn_Pay).perform();
	}

	public void enterPasswordforCard() {
		driver.switchTo().frame("threeDSIframe");
		txt_passwordforCard.click();
		txt_passwordforCard.sendKeys("passord");
		btn_OKafterpassword.click();
	}

	public boolean isOrderConfirmed() {
		return msg_OrderConfirm.isDisplayed();
	}
}
