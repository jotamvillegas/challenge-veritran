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

public class TestProductSearch_Drone {

    private WebDriver driver;
    private PageHome pageHome;

    @BeforeTest
    public void setUp () throws Exception {
        pageHome = new PageHome(driver);
        Parameters.loadParametersTest01();
        driver = pageHome.chromeDriverConnection(Parameters.urlHome);
    }

    @Test
    public void ProductSearchDrone () throws Exception {
        String screenPath = "Product Search Drone";
        PageSearch pageSearch = new PageSearch(driver);
        PageProductDetails pageProductDetails = new PageProductDetails(driver);

        if(pageHome.logoVisible()){
            Assert.assertEquals(pageHome.logoVisible(screenPath), true);

            pageSearch.enterProductName(Parameters.productSearch, screenPath);
            pageSearch.clickBtnSearch(screenPath);
            Assert.assertEquals(pageSearch.returnResults(), true);

            pageSearch.selectPageNumber(Parameters.pageNumber, screenPath);
            pageSearch.selectProductSponsoredAndNotSponsored(Parameters.articleNumber, screenPath);
            pageProductDetails.setValueProductInDetails();
            Assert.assertEquals(pageSearch.getValueProductInList(), pageProductDetails.getValueProductInDetails());
        }

    }

    @AfterTest
    public void tearDown (){
        driver.quit();
    }

}
