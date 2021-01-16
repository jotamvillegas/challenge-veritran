package com.project.pom.PagePortarlWeb;

import com.project.pom.Helpers.General;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.project.pom.Selectors.SelectorGeneral.*;

public class PageHome extends General {

    Logger logs = Logger.getLogger(PageHome.class);
    private WebDriver driver;

    public PageHome(WebDriver driver) {
        super(driver);
    }

    public boolean logoVisible () {
        if (isDisplayed(LOGO)){
            return true;
        }else{
            return false;
        }
    }

    public boolean logoVisible (String pathScreen) throws IOException {
        if (isDisplayed(LOGO)){
            logs.info("Page Loaded correctly");
            screenS("Logo visible home", pathScreen);
            waitExp(2);
            return true;
        }else{
            logs.info("Page not loaded");
            screenS("Error - Page not loaded", pathScreen);
            return false;
        }

    }

    public String getUrlHome (){
        return driver.getCurrentUrl();
    }


}
