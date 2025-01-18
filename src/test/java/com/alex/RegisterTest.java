package com.alex;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    @Test
    public void registerTest() throws InterruptedException {
        RegisterPage rp = new RegisterPage(driver);
        String verifyRegisterSuccess = "Your Account Has Been Created!";
        Assert.assertEquals(rp.registerAccount(), verifyRegisterSuccess);
    }
}
