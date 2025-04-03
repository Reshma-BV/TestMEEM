package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.PaymentCheckoutPage;
import pages.ProductPage;

public class PaymentCheckOutTest extends Base {
	ProductPage productpage;
	PaymentCheckoutPage pmntcheckoutpage;

	@Test
	public void verifyCheckoutWithHappyPath() throws InterruptedException {
		productpage = new ProductPage(driver);
		productpage.click_AcceptCookies();
		productpage.selectSize();
		productpage.click_AddToBag();
		productpage.click_ReviewBagandCheckout();
		productpage.click_Checkout();

		pmntcheckoutpage = new PaymentCheckoutPage(driver);
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

		pmntcheckoutpage.enterCardNumber("3700 0000 0000 002	");
		pmntcheckoutpage.enterExpiryDate("03/30");
		pmntcheckoutpage.enterSecurityCode("7373");
		pmntcheckoutpage.enterNameOnCard();
		pmntcheckoutpage.clickOnPayButton();

		boolean alertSuccess_Status = pmntcheckoutpage.isOrderConfirmed();
		Assert.assertTrue(alertSuccess_Status, "Order not confirmed");
	}

	@Test
	public void verifyCheckoutWithUnHappyPath() throws InterruptedException {
		productpage = new ProductPage(driver);
		productpage.click_AcceptCookies();
		productpage.selectSize();
		productpage.click_AddToBag();
		productpage.click_ReviewBagandCheckout();
		productpage.click_Checkout();

		pmntcheckoutpage = new PaymentCheckoutPage(driver);
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

		pmntcheckoutpage.enterCardNumber("3782 8224 6310 005");
		pmntcheckoutpage.enterExpiryDate("03/30");
		pmntcheckoutpage.enterSecurityCode("7373");
		pmntcheckoutpage.enterNameOnCard();
		pmntcheckoutpage.clickOnPayButton();
		pmntcheckoutpage.enterPasswordforCard();
		Assert.assertEquals(driver.getTitle(),"Cart","Invalid card accepted");
	}

}
