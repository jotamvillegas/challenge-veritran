package com.project.pom.Test_US01_ProductSearch;

import com.project.pom.Helpers.Parameters;
import com.project.pom.PagePortarlWeb.PageHome;
import com.project.pom.PagePortarlWeb.PageProductDetails;
import com.project.pom.PagePortarlWeb.PageSearch;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPageSelected {

    private WebDriver driver;
    private PageHome pageHome;

    @BeforeTest
    public void setUp () throws Exception {
        pageHome = new PageHome(driver);
        Parameters.loadParametersTest01();
        driver = pageHome.chromeDriverConnection(Parameters.urlHome);
    }

    @Test
    public void PageSelected () throws Exception {
        String screenPath = "Page Selected";
        PageSearch pageSearch = new PageSearch(driver);
        PageProductDetails pageProductDetails = new PageProductDetails(driver);

        if(pageHome.logoVisible()){
            Assert.assertEquals(pageHome.logoVisible(screenPath), true);

            pageSearch.enterProductName(Parameters.productSearch, screenPath);
            pageSearch.clickBtnSearch(screenPath);
            Assert.assertEquals(pageSearch.returnResults(), true);

            pageSearch.selectPageNumber(Parameters.pageNumber, screenPath);
            Assert.assertEquals(pageSearch.getPageNumberSelected(), String.valueOf(Parameters.pageNumber));
        }

    }

    @AfterTest
    public void tearDown (){
        driver.quit();
    }

}
