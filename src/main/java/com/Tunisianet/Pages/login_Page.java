package com.Tunisianet.Pages;

import com.Tunisianet.Base;
import com.Tunisianet.Locators.login_Locators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login_Page extends login_Locators{
    public login_Page(){
        PageFactory.initElements(driver,this);
    }
    public  static  login_Page instance ;
    public static login_Page getInstance(){
        if(instance == null){
            instance= new login_Page();
        }return instance ;
    }

    public void performLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
        connexionButtonIcon.click();
        ConnexionButton.click();
        email.sendKeys(Base.props.getProperty("mail"));
        password.sendKeys(Base.props.getProperty("password"));
        submit.click();
        Thread.sleep(3000);


    }

    public void performLoginAssertion() throws InterruptedException {
        connexionButtonIcon.click();
        Thread.sleep(2000);
        Assert.assertTrue((logoutButton).isDisplayed());
    }

}
