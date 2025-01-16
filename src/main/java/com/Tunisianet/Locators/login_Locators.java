package com.Tunisianet.Locators;

import com.Tunisianet.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_Locators extends Base {
    public login_Locators(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='user-info']")
    protected WebElement connexionButtonIcon;
    @FindBy(xpath = "//span[normalize-space()='Connexion']")
    protected WebElement ConnexionButton;
    @FindBy(xpath = "//input[@name='email']")
    protected WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    protected WebElement password;
    @FindBy(css = "#submit-login")
    protected WebElement submit;
    @FindBy(css = "div[class='co-heading'] h2 span")
    protected WebElement loginAssertion;
    @FindBy(css = ".logout")
    protected WebElement logoutButton;
}
