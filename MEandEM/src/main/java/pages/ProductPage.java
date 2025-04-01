package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	public WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@id='onetrust-accept-btn-handler']") private WebElement btn_cookie;

	@FindBy(xpath="//*[@id='react-aria-:R1imteuubaj5taH2:']") private WebElement Drpdwn_forSize;
	@FindBy(xpath="//*[@id='react-aria-:R1imteuubaj5taH1:-option-95068-151432']") private WebElement select_Size;
	@FindBy(xpath="(//*[contains(text(), 'Add to Bag')])[1]") private WebElement btn_AddToBag;
	@FindBy(xpath="(//*[contains(text(),'Review Bag and Checkout')])[1]") private WebElement btn_ReviewBagandCheckout;
	@FindBy(xpath="(//*[contains(text(),'Checkout')])[2]") private WebElement btn_Checkout;
		
	public void click_AcceptCookies() {
		btn_cookie.click();
	}	
	public void selectSize() {
		Drpdwn_forSize.click();
		select_Size.click();
	}
	public void click_AddToBag()
	{
		btn_AddToBag.click();
	}
	public void click_ReviewBagandCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_ReviewBagandCheckout));
		btn_ReviewBagandCheckout.click();
	}
	public void click_Checkout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_Checkout));
		btn_Checkout.click();
	}
}
