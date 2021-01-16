package com.project.pom.PagePortarlWeb;

import com.project.pom.Helpers.General;
import com.project.pom.Helpers.Parameters;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.project.pom.Selectors.SelectorGeneral.*;

public class PageShoppingCart  extends General {

    Logger logs = Logger.getLogger(PageShoppingCart.class);

    public PageShoppingCart(WebDriver driver) {
        super(driver);
    }

    public void enterToShoppingCart (String screenPath) throws IOException {
        click(BTN_SHOPPING_CART);
        logs.info("Entering to shopping cart");
        screenS("Enter to shopping cart", screenPath);
    }

    public void setProductValueInCart() throws Exception {
        String value = getText(PRODUCT_VALUE_IN_CART).substring(4);
        Parameters.setValue(value,"Product Search",1,5);
    }

    public String getProductValueInCart () throws Exception {
        Parameters.getValue("Product Search",1,5);
        String value = Parameters.value;
        return value;
    }

    public void btnActionDelete (String screenPath) throws Exception {
        click(BTN_DELETE_ITEM);
        waitExp(2);
        screenS("Shopping cart empty", screenPath);
    }

    public String verifyTitleCartEmpty(){
        return getText(TITLE_CART_EMPTY);
    }

    public String verifyCartCounter(){
        return getText(CART_COUNTER);
    }

}
