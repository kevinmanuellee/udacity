package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ChatPage {

    WebDriver driver;

    public ChatPage(WebDriver driver) {
//        String url = driver.getCurrentUrl();
//        int index = url.lastIndexOf('/');
//        String newUrl = url.substring(0, index+1) + "chat";
//        driver.get(newUrl);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "messageType")
    private WebElement messageType;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @FindBy(className = "displayMessages")
    private List<WebElement> displayMessages;

    public void updateMessage (String text, String type){
        messageText.sendKeys(text);
        Select dropdown = new Select(messageType);
        dropdown.selectByValue(type);
        submitButton.click();
    }

    public String getDisplayMessages(String text, String type){
        updateMessage(text, type);
        String updatedMessage = "";
        for(WebElement displayText : displayMessages){
            updatedMessage = displayText.getText();
        }
        return updatedMessage;
    }
}
