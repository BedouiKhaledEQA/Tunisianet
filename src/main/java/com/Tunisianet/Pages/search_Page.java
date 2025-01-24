package com.Tunisianet.Pages;

import com.Tunisianet.Locators.search_Locators;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class search_Page extends search_Locators{
    public search_Page(){
        PageFactory.initElements(driver,this);
    }

    public static search_Page instance;

    public static search_Page getInstance(){
        if(instance == null){
            instance=new search_Page();
        }return instance;
    }


    public void perform_Search_Item() throws InterruptedException {
        search_Bar_Box.sendKeys("asus");
        Thread.sleep(6000);
        submit_Search_Button.click();
        Thread.sleep(6000);

    }

    public void perform_Assertion_Item(){
        Assert.assertTrue((assertion_Item).isDisplayed());
    }
}
