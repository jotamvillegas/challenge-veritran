package com.project.pom.Helpers;

import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.TAB;

public class General {

    private WebDriver driver;
    private  String pathChromeDriver = "Chrome driver 87.0.4280.88/chromedriver_linux64/chromedriver";

    Logger logs = Logger.getLogger(General.class);

    public General(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void waitImp(int Seconds) {
        driver.manage().timeouts().implicitlyWait(Seconds * 1000, TimeUnit.MILLISECONDS);
    }

    public void waitExp(int Seconds) {
        try {
            Thread.sleep(Seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void screenS(String nombreCaptura, String screenPath) throws IOException {
        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("YYYY-MM-dd/HH");
        DateFormat formatoImg = new SimpleDateFormat("HH:mm:ss:mmm");
        String browser = (driver.toString().contains("chrome")) ? "chrome" : "firefox";
        String pathEvidence = "Evidences/" + browser + "/" + formato.format(fecha)
                + "hs/" + screenPath;
        System.out.println("Evidences path: /" + pathEvidence);
        File miCaptura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(miCaptura,
                    new File(pathEvidence + "/" + formatoImg.format(fecha) + " " + nombreCaptura + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void typeNumber(String inputNumber, By locator) {
        driver.findElement(locator).sendKeys(inputNumber);
    }

    public void tab(By locator) {
        driver.findElement(locator).sendKeys(TAB);
    }

    public void clearField(By locator) {
        driver.findElement(locator).clear();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebDriver chromeDriverConnection(String url) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/" +
                pathChromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        visit(url);
        initializeComponent();
        return driver;
    }

    public void initializeComponent() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/ConfigLog/log.properties");
    }

    public void scrollDownWithKeys(By locator, int loopCount) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        for (int i = 0; i <= loopCount; i++) {
            actions.moveToElement(element).click().sendKeys(Keys.DOWN).build().perform();
        }

    }

    public List<WebElement> loadList(By locator) {
        List<WebElement> list = driver.findElements(locator);
        return list;
    }

    public boolean foundElement(List<WebElement> list, String value) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getText().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

}
