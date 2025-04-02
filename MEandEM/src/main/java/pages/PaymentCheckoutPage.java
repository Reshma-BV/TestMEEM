package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(css ="div[class='mt-16 flex flex-col-reverse gap-8 sm:flex-row sm:gap-12'] span[class='type-body-sm z-10']") private WebElement btn_Delivery_SubmittoContinue;
	
	@FindBy(xpath="//span[normalize-space()='Submit to Continue']") private WebElement btn_Billing_SubmitToContinue;
	
	@FindBy(xpath="//span[normalize-space()='Submit to Continue']") private WebElement btn_DeliveryMethod_SubmitToContinue;
	
	@FindBy(xpath="//input[@aria-label='Card number']") private WebElement txt_CardNumber;
	@FindBy(xpath="//input[@aria-label='Expiry date']") private WebElement txt_Expirydate;
	@FindBy(xpath="//input[@aria-label='Security code']") private WebElement txt_SecurityCode;
	@FindBy(xpath="//input[@name='holderName']") private WebElement txt_NameOnCard;
	@FindBy(xpath="//*[text()='Pay ']") private WebElement btn_Pay;
	
	@FindBy(xpath="//*[@id='primary']") private WebElement btn_gpay;
	
	@FindBy(xpath="//*[text()='Thank you for your purchase.']") private WebElement msg_OrderConfirm;
	@FindBy(xpath="//span[text()='checkout.paymentMethods.paymentMethodDeclined']") private WebElement alert_declinedPayment;

	@FindBy(xpath="(//div[@id='address_list_item0'])[2]") private WebElement suggestion;
	
	@FindBy(xpath="//*[text()='Edit']") private WebElement icon_edit;
	@FindBy(xpath="//iframe[@class='js-iframe' and @title='Iframe for card number']") private WebElement iframe_cardnum;
	
	public void enterEmailOnEmailField(String email) {	
		txt_Email.click();		
		txt_Email.sendKeys(email);
	}
	public void clickOnContinueButtonAfterEmail()
	{
		btn_Continue.click();
	}
	public void enterFirstNameOnNameField() {	
		if(icon_edit.isDisplayed())
		{
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
		Select countrydrpdwn=new Select(drpdwn_Country);
		countrydrpdwn.selectByValue("GB");		
	}
	public void enterAddressOnAddressLine1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", txt_AddressLine1);
		js.executeScript("arguments[0].value='stratford1';", txt_AddressLine1);
	}
	public void selectRegion() {
		Select selectregion=new Select(drpdwn_Region);
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
		Actions act=new Actions(driver);
		for(int i=0;i<=6;i++) {
			act.moveToElement(btn_DeliveryMethod_SubmitToContinue).click().perform();
		}	
		
	}	
	public void click_toConfirmBillingAddressSameasDeliveryAddress() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", btn_Billing_SubmitToContinue);
	}
	public void click_submittoContinueforDeliveryMethod() {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(btn_DeliveryMethod_SubmitToContinue));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100);");
		js.executeScript("arguments[0].scrollIntoView(true);", btn_DeliveryMethod_SubmitToContinue);
		js.executeScript("arguments[0].click", btn_DeliveryMethod_SubmitToContinue);
	}
	public void enterCardNumber(String cardnumber) {		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='js-iframe' and @title='Iframe for card number']")));
		txt_CardNumber.sendKeys(cardnumber);
		driver.switchTo().defaultContent();
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
