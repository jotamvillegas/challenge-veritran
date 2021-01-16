package com.project.pom.Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *  Para el package Selectors se utilizó una sola clase SelectorsGeneral por el scope del proyecto en si.
 *  Si fuera un proyecto más grande y complejo, la idea sería poder separar los selectores en clases, haciendo uso de
 *  la modularización como concepto fundamental de JAVA.
 */

public class SelectorGeneral {

    public WebDriver driver;

    public SelectorGeneral (WebDriver driver) {
        this.driver = driver;
    }

    // PAGE HOME
    public final static By LOGO = By.id("nav-logo-sprites");

    // PAGE PRODUCT DETAILS
    public static By FINAL_PRICE;
    public static void setLocatorToFinalPrice (String atributte) {
        FINAL_PRICE = By.xpath("//div[@id='price']//tr[@id='" + atributte + "']/td[2]/span[1]");
    }
    public final static By ATRIBUTTE_FINAL_PRICE = By.xpath("//div[@id='price']//tr");
    public final static By BTN_ADD_TO_CART = By.id("add-to-cart-button");
    public final static By TITLE_PRODUCT_ADD = By.xpath("//h1[contains(text(),'Agregado al carrito')]");

    // PAGE SEARCH
    public final static By INPUT_PRODUCT_SEARCH = By.id("twotabsearchtextbox");
    public final static By BTN_SEARCH = By.id("nav-search-submit-button");
    public final static By RESULTS = By.xpath("//div[@class='sg-col-4-of-12 s-result-item s-asin " +
            "sg-col-4-of-16 sg-col sg-col-4-of-20']");
    public final static By FOLLOWING_PAGE = By.xpath("//ul[@class='a-pagination']//a[contains(text(),'Siguiente')]");
    public final static By PREVIOUS_PAGE = By.xpath("//ul[@class='a-pagination']//a[contains(text(),'Anterior')]");
    public final static By PAGINATION = By.xpath("//ul[@class='a-pagination']//li[@class='a-normal']");
    public final static By ARTICLE_SPONSORED_AND_NOT_SPONSORED = By.xpath("//div[contains(@class,'s-expand-height " +
            "s-include-content-margin s-border-bottom s-latency-cf-section')]");
    public final static By PRODUCT_LIST_NOT_SPONSORED = By.xpath("//div[@class='sg-col-4-of-12 s-result-item " +
            "s-asin sg-col-4-of-16 sg-col sg-col-4-of-20']");
    public final static By PRODUCT_LIST_SPONSORED = By.xpath("//div[@class='sg-col-4-of-12 s-result-item s-asin " +
            "sg-col-4-of-16 AdHolder sg-col sg-col-4-of-20']");
    public final static By PRODUCT_FULL_LIST = By.xpath("//div[contains(@class,'s-result-item')]");
    public final static By POINT_SCROLL_DOWN = By.xpath("//div[@id='search']//div[@class='a-section a-spacing-small " +
            "a-spacing-top-small']");
    public final static By PAGE_SELECTED = By.xpath("//ul[@class='a-pagination']//li[@class='a-selected']");
    public static By PRODUCT_VALUE_PART_INTEGER;
    public static By PRODUCT_VALUE_PART_DECIMAL;
    public static void setLocatorByIndex(String index) {
        PRODUCT_VALUE_PART_INTEGER = By.xpath("//div[@data-index='" + index +
                "']//span[@class='a-price']/span[@aria-hidden='true']/span[@class='a-price-whole']");
        PRODUCT_VALUE_PART_DECIMAL = By.xpath("//div[@data-index='" + index +
                "']//span[@class='a-price']/span[@aria-hidden='true']/span[@class='a-price-fraction']");
    }

    // PAGE SHOPPING CART
    public final static By BTN_SHOPPING_CART = By.xpath("//a[@id='nav-cart']");
    public final static By PRODUCT_VALUE_IN_CART = By.xpath("//div[@class='sc-list-item-content']" +
            "//p[@class='a-spacing-small']/span");
    public final static By BTN_DELETE_ITEM = By.xpath("//div[@class='a-row sc-action-links']" +
            "//span[@class='a-size-small sc-action-delete']//input");
    public final static By TITLE_CART_EMPTY = By.xpath("//h2[contains(text(),'Tu Carrito de Amazon está vacío')]");
    public final static By CART_COUNTER = By.id("nav-cart-count-container");


}
