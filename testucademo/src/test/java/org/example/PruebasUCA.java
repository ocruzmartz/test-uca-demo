package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PruebasUCA {
    public WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickBuscarConGoogle() {
        WebElement user;
        WebElement password;
        WebElement buscarGooBtn;


        user = driver.findElement(By.cssSelector("#user-name"));
        password = driver.findElement(By.cssSelector("#password"));
        buscarGooBtn = driver.findElement(By.cssSelector("#login-button"));

        user.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        buscarGooBtn.click();

    }

    public void addToCar(){
        WebElement itemOne;
        WebElement itemTwo;

        itemOne = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        itemTwo = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));

        itemOne.click();
        itemTwo.click();

    }

    public void showItems(){
        WebElement seeCar;
        seeCar = driver.findElement(By.cssSelector("#shopping_cart_container > a"));

        seeCar.click();
    }

    @Test
    public void test() {
        setUp();
        clickBuscarConGoogle();
        addToCar();
        showItems();
    }
}
