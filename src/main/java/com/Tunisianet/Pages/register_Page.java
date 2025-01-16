package com.Tunisianet.Pages;

import com.Tunisianet.Locators.register_Locators;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class register_Page extends register_Locators{
    public register_Page(){
        PageFactory.initElements(driver,this);
    }

    public static register_Page instance;

    public static register_Page getInstance(){
        if(instance == null){
            instance =new register_Page();
        }return instance;
    }
    user_Page user =new user_Page();

    public void performRegister() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
        connexionButtonIcon.click();
        ConnexionButton.click();
        createAccountButton.click();
        genderRadioButton.click();
        firstname.sendKeys(user.getFirstname());
        lastname.sendKeys(user.getLastname());
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        birthdayInput.sendKeys(user.getBirthday());
        saveButton.click();
        Thread.sleep(3000);


    }

    public void performRegisterAssertion(){
        connexionButtonIcon.click();
        Assert.assertTrue((connectedUserButton).isDisplayed());
    }
}
