package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.PaymentCheckoutPage;
import pages.ProductPage;

public class PaymentCheckOutTest extends Base{
	
	@Test
	public void verifyCheckoutWithUnhappyPath() {
		ProductPage productpage=new ProductPage(driver);
		productpage.click_AcceptCookies();
		productpage.selectSize();
		productpage.click_AddToBag();
		productpage.click_ReviewBagandCheckout();
		productpage.click_Checkout();
		
		PaymentCheckoutPage pmntcheckoutpage=new PaymentCheckoutPage(driver);
		pmntcheckoutpage.enterEmailOnEmailField("niya1@gmail.com");
		pmntcheckoutpage.clickOnContinueButtonAfterEmail();
		pmntcheckoutpage.enterFirstNameOnNameField();
		pmntcheckoutpage.enterLastNameOnNameField();
		pmntcheckoutpage.enterPhoneNumber();
		pmntcheckoutpage.selectCountryName();
		pmntcheckoutpage.enterAddressOnAddressLine1();
		pmntcheckoutpage.selectRegion();
		pmntcheckoutpage.enterPostCode();
		pmntcheckoutpage.enterCity();
		pmntcheckoutpage.click_submittocontinuebtnafterEnteringCustomerDetails();
		pmntcheckoutpage.click_toConfirmBillingAddressSameasDeliveryAddress();
		pmntcheckoutpage.click_submittoContinueforDeliveryMethod();
		
		pmntcheckoutpage.enterCardNumber("3700 0000 0000 0001");
		pmntcheckoutpage.enterExpiryDate("03/30");
		pmntcheckoutpage.enterSecurityCode("737");
		pmntcheckoutpage.enterNameOnCard("Reshma");
		pmntcheckoutpage.clickOnPayButton();
		
		boolean alert_Status=pmntcheckoutpage.isAlertdisplayedforDeclinedPayment();
		Assert.assertTrue(alert_Status, "Invalid card accepted");
	}

}
