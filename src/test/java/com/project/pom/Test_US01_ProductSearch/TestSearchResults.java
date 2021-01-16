package com.project.pom.Test_US01_ProductSearch;

import com.project.pom.Helpers.Parameters;
import com.project.pom.PagePortarlWeb.PageHome;
import com.project.pom.PagePortarlWeb.PageSearch;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSearchResults {

    private WebDriver driver;
    private PageHome pageHome;

    @BeforeTest
    public void setUp () throws Exception {
        pageHome = new PageHome(driver);
        Parameters.loadParametersTest01();
        driver = pageHome.chromeDriverConnection(Parameters.urlHome);
    }

    @Test
    public void SearchResultds() throws Exception {
        String screenPath = "Search Results";
        PageSearch pageSearch = new PageSearch(driver);

        if(pageHome.logoVisible()){
            Assert.assertEquals(pageHome.logoVisible(screenPath), true);
            pageSearch.enterProductName(Parameters.productSearch, screenPath);
            pageSearch.clickBtnSearch(screenPath);
            Assert.assertEquals(pageSearch.returnResults(), true);
        }

    }

    @AfterTest
    public void tearDown (){
        driver.quit();
    }

}
