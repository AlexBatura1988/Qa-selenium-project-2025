package com.alex;

import com.alex.temp.GenerateEmailDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class RegisterPage extends BasePage {

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountBtn;
    @FindBy(linkText = "Register")
    WebElement registerBtn;
    @FindBy(xpath = "//*[@id='input-firstname']")
    WebElement firstNameInput;
    @FindBy(xpath = "//*[@id='input-lastname']")
    WebElement lastNameInput;
    @FindBy(xpath = "//*[@id='input-email']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id='input-telephone']")
    WebElement telephoneInput;
    @FindBy(xpath = "//*[@id='input-password']")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id='input-confirm']")
    WebElement confirmPasswordInput;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement policyBtn;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitBtn;
    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement verifyCreatingAccText;

    GenerateEmailDemo emailDemo = new GenerateEmailDemo();
    String email = emailDemo.GenerateEmail();

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String registerAccount() throws InterruptedException {
        click(myAccountBtn);
        click(registerBtn);
        fillText(firstNameInput, "Alex");
        fillText(lastNameInput, "Batura");
        fillText(emailInput, email);
        fillText(telephoneInput, "123456789");
        goToEle(passwordInput);
        fillText(passwordInput, "alex123");
        fillText(confirmPasswordInput, "alex123");
        click(policyBtn);
        click(submitBtn);
        return verifyCreatingAccText.getText();

    }




}
