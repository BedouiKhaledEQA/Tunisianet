package com.Tunisianet.Locators;

import com.Tunisianet.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class search_Locators extends Base {
    public search_Locators(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "search_query_top")
    protected WebElement search_Bar_Box;
    @FindBy(xpath = "//button[@name='submit_search']")
    protected WebElement submit_Search_Button;
    @FindBy(xpath = "//section[@id='wrapper']//nav[1]//div[1]")
    protected WebElement assertion_Item;
}
