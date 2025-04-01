package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentCheckoutPage {
	public WebDriver driver;

	public PaymentCheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name='email']") private WebElement txt_Email;
	@FindBy(xpath="(//span[contains(text(),'Continue')])[1]") private WebElement btn_Continue;
	@FindBy(xpath="//*[@name='firstName']") private WebElement txt_FirstName;
	@FindBy(xpath="//*[@name='lastName']") private WebElement txt_LastName;
	@FindBy(xpath="//*[@name='telephone']") private WebElement txt_PhoneNumber;
	@FindBy(xpath="//*[@name='countryCode']") private WebElement drpdwn_Country;
	@FindBy(xpath="//*[@name='addressLine1']") private WebElement txt_AddressLine1;
	@FindBy(xpath="//*[@name='regionCode']") private WebElement drpdwn_Region;
	@FindBy(xpath="//*[@name='postcode']") private WebElement txt_PostCode;
	@FindBy(xpath="//*[@name='city']") private WebElement txt_City;
	@FindBy(xpath="//button[@type='submit']//span[@class='type-body-sm z-10'][normalize-space()='Submit to Continue']") private WebElement btn_Delivery_SubmittoContinue;
	
	@FindBy(xpath="//span[normalize-space()='Submit to Continue']") private WebElement btn_Billing_SubmitToContinue;
	
	@FindBy(xpath="//span[normalize-space()='Submit to Continue']") private WebElement btn_DeliveryMethod_SubmitToContinue;
	
	@FindBy(xpath="(//*[@class='adyen-checkout__input-wrapper'])[1]") private WebElement txt_CardNumber;	
	@FindBy(xpath="//input[contains(@id,'adyen-checkout-encryptedExpiryDate-1743497059454')]") private WebElement txt_Expirydate;
	@FindBy(xpath="//input[contains(@id,'adyen-checkout-encryptedSecurityCode-1743497059455')]") private WebElement txt_SecurityCode;
	@FindBy(xpath="//input[contains(@id,'adyen-checkout-holderName-1743497059456')]") private WebElement txt_NameOnCard;
	@FindBy(xpath="//*[text()='Pay ']") private WebElement btn_Pay;
	
	@FindBy(xpath="//*[@id='primary']") private WebElement btn_gpay;
	
	@FindBy(xpath="//*[text()='Thank you for your purchase.']") private WebElement msg_OrderConfirm;
	@FindBy(xpath="//span[text()='checkout.paymentMethods.paymentMethodDeclined']") private WebElement alert_declinedPayment;

	@FindBy(xpath="(//div[@id='address_list_item0'])[2]") private WebElement suggestion;
	
	public void enterEmailOnEmailField(String email) {	
		txt_Email.click();		
		txt_Email.sendKeys(email);
	}
	public void clickOnContinueButtonAfterEmail()
	{
		btn_Continue.click();
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@fdprocessedid='afsyy']//*[name()='svg']")));
	}
	public void enterFirstNameOnNameField() {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_FirstName);
		js.executeScript("arguments[0].value='Nantha';", txt_FirstName);
	}
	public void enterLastNameOnNameField() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_LastName);
		js.executeScript("arguments[0].value='N';", txt_LastName);
	}
	public void enterPhoneNumber() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_PhoneNumber);
		js.executeScript("arguments[0].value='987654321';", txt_PhoneNumber);
	}
	public void selectCountryName() {
		Select countrydrpdwn=new Select(drpdwn_Country);
		countrydrpdwn.selectByValue("GB");		
	}
	public void enterAddressOnAddressLine1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_AddressLine1);
		js.executeScript("arguments[0].value='stratford';", txt_AddressLine1);
	}
	public void selectRegion() {
		Select selectregion=new Select(drpdwn_Region);
		selectregion.selectByValue("GB-ENG");
	}
	public void enterPostCode() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_PostCode);
		js.executeScript("arguments[0].value='E152RS';", txt_PostCode);
	}
	public void enterCity() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_City);
		js.executeScript("arguments[0].value='StartFord';", txt_City);	
	}
	public void click_submittocontinuebtnafterEnteringCustomerDetails() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btn_Delivery_SubmittoContinue));
		//btn_Delivery_SubmittoContinue.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", btn_Delivery_SubmittoContinue);		
	}	
	public void click_toConfirmBillingAddressSameasDeliveryAddress() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", btn_Billing_SubmitToContinue);
	}
	public void click_submittoContinueforDeliveryMethod() {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(btn_DeliveryMethod_SubmitToContinue));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0, 100);");
		//js.executeScript("arguments[0].scrollIntoView(true);", btn_DeliveryMethod_SubmitToContinue);
		js.executeScript("arguments[0].click", btn_DeliveryMethod_SubmitToContinue);
	}
	public void enterCardNumber(String cardnumber) {		
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='js-iframe']")));
		txt_CardNumber.sendKeys(cardnumber);
	}
	public void enterExpiryDate(String date) {
		txt_Expirydate.sendKeys(date);
	}
	public void enterSecurityCode(String securitycode) {
		txt_SecurityCode.sendKeys(securitycode);
	}
	public void enterNameOnCard(String nameoncard) {
		txt_NameOnCard.sendKeys(nameoncard);
	}
	public void clickOnPayButton() {
		btn_Pay.click();
	}
	
	public boolean isAlertdisplayedforDeclinedPayment()
	{
		return alert_declinedPayment.isDisplayed();
	}
}
