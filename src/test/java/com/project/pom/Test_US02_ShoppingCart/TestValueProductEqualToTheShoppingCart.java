package com.project.pom.Test_US02_ShoppingCart;

import com.project.pom.Helpers.Parameters;
import com.project.pom.PagePortarlWeb.PageHome;
import com.project.pom.PagePortarlWeb.PageProductDetails;
import com.project.pom.PagePortarlWeb.PageSearch;
import com.project.pom.PagePortarlWeb.PageShoppingCart;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestValueProductEqualToTheShoppingCart {

    private WebDriver driver;
    private PageHome pageHome;

    @BeforeTest
    public void setUp () throws Exception {
        pageHome = new PageHome(driver);
        Parameters.loadParametersTest01();
        driver = pageHome.chromeDriverConnection(Parameters.urlHome);
    }

    @Test
    public void ShoppingCart () throws Exception {
        String screenPath = "Shopping Cart";
        PageSearch pageSearch = new PageSearch(driver);
        PageProductDetails pageProductDetails = new PageProductDetails(driver);
        PageShoppingCart pageShoppingCart = new PageShoppingCart(driver);

        if(pageHome.logoVisible()){
            Assert.assertEquals(pageHome.logoVisible(screenPath), true);

            pageSearch.enterProductName(Parameters.productSearch, screenPath);
            pageSearch.clickBtnSearch(screenPath);
            Assert.assertEquals(pageSearch.returnResults(), true);

            pageSearch.selectPageNumber(Parameters.pageNumber, screenPath);
            pageSearch.selectProductSponsoredAndNotSponsored(Parameters.articleNumber, screenPath);
            pageProductDetails.setValueProductInDetails();
            Assert.assertEquals(pageSearch.getValueProductInList(), pageProductDetails.getValueProductInDetails());
            pageProductDetails.setCartCounter();
            Assert.assertEquals(pageShoppingCart.verifyCartCounter(), Parameters.cartCounter);

            pageProductDetails.addToShopphingCart();
            pageProductDetails.setCartCounter();
            Assert.assertEquals(pageProductDetails.verifyProductAdd(screenPath),Parameters.expectedResultAddToCart);
            Assert.assertEquals(pageShoppingCart.verifyCartCounter(), Parameters.cartCounter);

            pageShoppingCart.enterToShoppingCart(screenPath);
            pageShoppingCart.setProductValueInCart();
            Assert.assertEquals(pageProductDetails.getValueProductInDetails(), pageShoppingCart.getProductValueInCart());

        }

    }

    @AfterTest
    public void tearDown (){
        driver.quit();
    }

}
