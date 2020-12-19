package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
//    private String username;
//    private String password;

    public LoginPage(WebDriver driver) {
//        String url = driver.getCurrentUrl();
//        int index = url.lastIndexOf('/');
//        String newUrl = url.substring(0, index+1) + "login";
//        driver.get(newUrl);
        PageFactory.initElements(driver, this);
//        this.username = username;
//        this.password = password;
    }

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public void login(String username, String password){
//        this.inputUsername.clear();
        this.inputUsername.sendKeys(username);
//        this.inputPassword.clear();
        this.inputPassword.sendKeys(password);
        submitButton.click();
//        return new ChatPage(this.driver);
    }
}
