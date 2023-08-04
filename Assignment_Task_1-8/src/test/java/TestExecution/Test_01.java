package TestExecution;

import org.testng.annotations.Test;

import Basic.TestBase;
import POM.CommonMenuPage;

public class Test_01 extends TestBase {

	@Test(priority = 1, description = "To verify the Add to cart Functionality.")
	public void testAddToCartSuccess() throws InterruptedException {
		CommonMenuPage cmn = new CommonMenuPage(driver);
		cmn.SearchAndclickonProduct("books to read");
		cmn.SelectFirstBook();
		String abc = cmn.handleWindow();
		cmn.clickonAddtoCart();
		cmn.validateProductinCart(abc);
		cmn.validateItemInCart("1");
	}

	@Test(priority = 2, description = "To verify the Add to cart Functionality with Invalid Data.")
	public void testAddToCartFail() throws InterruptedException {
		CommonMenuPage cmn = new CommonMenuPage(driver);
		cmn.SearchAndclickonProduct("books to read");
		cmn.SelectFirstBook();
		String abc = cmn.handleWindow();
		cmn.clickonAddtoCart();
		cmn.validateProductinCart("xyz");
		cmn.validateItemInCart("2");
	}

}
