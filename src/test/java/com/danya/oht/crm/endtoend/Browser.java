package com.danya.oht.crm.endtoend;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Lazy
@ApplicationScope
@Component

public class Browser {

    private WebDriver driver;

//    @Value("${webdriver.gecko.driver}")
//    private String geckoPath;

    public Browser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Desktop\\danya\\krok\\university-4-1\\diplom\\src\\geckodriver.exe");
//        System.setProperty("webdriver.gecko.driver", geckoPath);
        driver = new FirefoxDriver();


    }

    public void openGoogle() {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
    }

    public void openHomepage() {
        driver.get("http://localhost:8080/");
    }

    public List<WebElement> findCategories(By by) {
        return driver.findElements(by);
    }
    
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
    
    public String getTitle() {
        return driver.getTitle();
    }

    public void openCreateOrder() {
        
    }

    public void open(String s) {
    }
}
