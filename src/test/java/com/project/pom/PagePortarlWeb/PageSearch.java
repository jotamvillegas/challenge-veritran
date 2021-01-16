package com.project.pom.PagePortarlWeb;

import com.project.pom.Helpers.General;
import com.project.pom.Helpers.Parameters;
import com.project.pom.Selectors.SelectorGeneral;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static com.project.pom.Selectors.SelectorGeneral.*;

public class PageSearch extends General {

    Logger logs = Logger.getLogger(PageSearch.class);
    private String productPrice= "";

    public PageSearch(WebDriver driver) {
        super(driver);
    }

    public void enterProductName(String nameProduct, String screenPath) throws IOException {
        type(nameProduct, INPUT_PRODUCT_SEARCH);
        logs.info("Product name input");
        screenS("Product name input", screenPath);
    }

    public void clickBtnSearch (String screenPath) throws IOException {
        click(BTN_SEARCH);
        logs.info("Click on the button search");
        waitImp(5);
        screenS("Searchs first results", screenPath);
    }

    public boolean returnResults (){
        List<WebElement> elements = loadList(RESULTS);
        if (elements.size() > 0){
            logs.info("The searchs return " + elements.size() + " results");
            return true;
        } else {
            logs.info("The searchs NO return results");
            return false;
        }
    }

    public void btnFollowingPager (String screenPath) throws IOException {
        click(FOLLOWING_PAGE);
        logs.info("Click on the button following page");
        waitExp(3);
        screenS("Following page", screenPath);
    }

    public void btnPreviousPager (String screenPath) throws IOException {
        click(PREVIOUS_PAGE);
        logs.info("Click on the button previous page");
        waitExp(3);
        screenS("Previous page", screenPath);
    }

    public boolean maxPaginationValue (int value){
        int maxPaginationValue = 7;
        if (value <= maxPaginationValue){
            return true;
        } else {
            return false;
        }
    }

    public void selectPageNumber (Integer pageNumber, String screenPath) throws IOException {
        List<WebElement> paginationButtons = loadList(PAGINATION);
        if (paginationButtons.size() > 0){
            if (maxPaginationValue(pageNumber)) {
                while (!foundElement(paginationButtons, String.valueOf(pageNumber))) {
                    int x = paginationButtons.size() - 1;
                    paginationButtons.get(x).click();
                    paginationButtons.clear();
                    paginationButtons = loadList(PAGINATION);
                }
                for (int i = 0; i < paginationButtons.size(); i++) {
                    if (paginationButtons.get(i).getText().equals(pageNumber.toString())) {
                        paginationButtons.get(i).click();
                        logs.info("Click on the page number " + pageNumber);
                        break;
                    }
                }
            } else {
                logs.info("the range of pagination is 1 - 7 pages! Please, change page number.");
                System.out.println("the range of pagination is 1 - 7 pages! Please, change page number.");
            }
        } else {
            logs.info("Paginator is not displayed");
        }
        waitExp(2);
        getPageNumberSelected();
        screenS("Results from page " + pageNumber.toString(), screenPath);
    }

    public String getPageNumberSelected (){
        return getText(PAGE_SELECTED);
    }

    private void setValueProduct (String index) throws Exception {
        SelectorGeneral.setLocatorByIndex(index);
        productPrice = getText(PRODUCT_VALUE_PART_INTEGER) + "." + getText(PRODUCT_VALUE_PART_DECIMAL);
        Parameters.setValue(productPrice, "Product Search", 1, 3);
        logs.info("the results product value was saved in the file .xlsx");
        waitExp(2);
    }

    public void selectProductSponsoredAndNotSponsored(Integer numberElement, String screenPath) throws Exception {
        List<WebElement> list = findElements(ARTICLE_SPONSORED_AND_NOT_SPONSORED);
        if (list.size() > 0){
            for (int i = 0; i < list.size(); i++){
                if (i == (numberElement - 1)){
                    scrollDownWithKeys(POINT_SCROLL_DOWN,3);
                    setValueProduct(String.valueOf(numberElement));
                    list.get(i).click();
                    logs.info("Select product nro " + numberElement + "of the product list");
                    screenS("Product Selected", screenPath);
                    break;
                }
            }
        }
    }

    public String getValueProductInList (){
        return productPrice;
    }



}
