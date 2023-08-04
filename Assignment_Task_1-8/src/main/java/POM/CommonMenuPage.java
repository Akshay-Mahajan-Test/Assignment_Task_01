package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Basic.TestBase;

public class CommonMenuPage extends TestBase {

	WebDriver driver;

	public CommonMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='q']")
	private WebElement textboxSearchBar;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonSearch;

	@FindBy(xpath = "//li[@class='Y5N33s']")
	private List<WebElement> listOfSearchOptions;

	@FindBy(xpath = "//div[@class='CXW8mj']")
	private List<WebElement> listofBooks;

	@FindBy(xpath = "//span[@class='B_NuCI']")
	private WebElement labelofProduct;

	@FindBy(xpath = "//div[@class='_2-uG6-']")
	private WebElement labelofAddToCartProduct;

	@FindBy(xpath = "//*[text()='Add to cart']")
	private WebElement addToCart;

	@FindBy(xpath = "no_add_to_cart")
	private WebElement NoaddToCart;

	@FindBy(xpath = "//*[text()='Flipkart (1)']")
	private WebElement productInCart;

	@FindBy(xpath = "(//div[@class='nxl3SA'])[1]")
	private WebElement labelPriceItem;

	@FindBy(xpath = "//input[@value='1']")
	private WebElement value;

	@FindBy(xpath = "//div[@class='_2nQDXZ']")
	private WebElement infoOfBook;

	public void SearchAndclickonProduct(String Option) throws InterruptedException {
		textboxSearchBar.sendKeys(Option);
		for (int i = 0; i < listOfSearchOptions.size() - 1; i++) {
			if (listOfSearchOptions.get(i).getText().contains(Option)) {
				listOfSearchOptions.get(i).click();
			}
		}
	}

	public void SelectFirstBook() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(listofBooks.get(0)).click().build().perform();
	}

	public String handleWindow() throws InterruptedException {
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		Thread.sleep(5000);
		System.out.println(labelofProduct.getText());
		return labelofProduct.getText();
	}

	public void clickonAddtoCart() {

		addToCart.click();
	}

	public void NoAddtoCart() {
		NoaddToCart.click();
	}

	public void validateProductinCart(String option) {
		System.out.println(labelofAddToCartProduct.getText());
		Assert.assertTrue(option.contains(labelofAddToCartProduct.getText()), "Item are Mismatched");
	}

	public void validateItemInCart(String item) {

		Assert.assertTrue(labelPriceItem.getText().contains(item), "Item In Cart are not match with Actual value.");
	}

}
