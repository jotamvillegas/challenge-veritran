package com.project.pom.Test_US01_ProductSearch;

import com.project.pom.Helpers.Parameters;
import com.project.pom.PagePortarlWeb.PageHome;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoadHomePage {

    private WebDriver driver;
    private PageHome pageHome;

    @BeforeTest
    public void setUp () throws Exception {
        pageHome = new PageHome(driver);
        Parameters.loadParametersTest01();
        driver = pageHome.chromeDriverConnection(Parameters.urlHome);
    }

    @Test
    public void LoadHomePage () throws Exception {
        String screenPath = "Load Home Page";

        if(pageHome.logoVisible()){
            Assert.assertEquals(pageHome.logoVisible(screenPath), true);
        }

    }

    @AfterTest
    public void tearDown (){
        driver.quit();
    }

}
