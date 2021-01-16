package com.project.pom.PagePortarlWeb;

import com.project.pom.Helpers.General;

import com.project.pom.Helpers.Parameters;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static com.project.pom.Selectors.SelectorGeneral.*;

public class PageProductDetails extends General {

    Logger logs = Logger.getLogger(PageProductDetails.class);

    public PageProductDetails(WebDriver driver) {
        super(driver);
    }

    public void setValueProductInDetails() throws Exception {
        waitExp(1);
        String value = "", idAtributte = "";
        WebElement element = findElement(ATRIBUTTE_FINAL_PRICE);
        idAtributte = element.getAttribute("ID");
        if (element.getAttribute("ID").equals("priceblock_saleprice_row")){
            setLocatorToFinalPrice("priceblock_saleprice_row");
            String fp = getText(FINAL_PRICE);
            value = fp.substring(4);
        } else {
            setLocatorToFinalPrice("priceblock_ourprice_row");
            String fp = getText(FINAL_PRICE);
            value = fp.substring(4);
        }
        Parameters.setValue(value,"Product Search", 1, 4);
        logs.info("the details product value was saved in the file .xlsx");
    }

    public String getValueProductInDetails () throws Exception {
        String value = Parameters.getValue("Product Search", 1, 4);
        return value;
    }

    public void addToShopphingCart (){
        waitExp(1);
        click(BTN_ADD_TO_CART);
        logs.info("Click on the button 'Add to Cart'");
    }

    public String verifyProductAdd(String screenPath) throws IOException {
        screenS("Product add to cart", screenPath);
        logs.info("Message is displayed: " + getText(TITLE_PRODUCT_ADD));
        return getText(TITLE_PRODUCT_ADD);
    }

    public void setCartCounter () throws Exception {
        Parameters.setValue(getText(CART_COUNTER),"Product Search", 1,6);
    }


}
