package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.LoginConstants;
import org.testng.Assert;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class LoginService {

    public static void doLogin(String email, String password){
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public static void setEmail(String email){
        MobileActionManager.waitPresence(LoginConstants.EMAIL_INPUT_LOCATOR);
        MobileActionManager.setInput(LoginConstants.EMAIL_INPUT_LOCATOR, email);
    }

    public static void setPassword(String password){
        MobileActionManager.waitPresence(LoginConstants.PASSWORD_INPUT_LOCATOR);
        MobileActionManager.setInput(LoginConstants.PASSWORD_INPUT_LOCATOR, password);
    }

    public static void clickLoginButton(){
        MobileActionManager.waitClickable(LoginConstants.SIGN_IN_BUTTON_LOCATOR);
        MobileActionManager.click(LoginConstants.SIGN_IN_BUTTON_LOCATOR);
    }

    public static void isViewLoaded(){
        MobileActionManager.waitVisibility(LoginConstants.SIGN_UP_BUTTON_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(LoginConstants.EMAIL_INPUT_LOCATOR), LoginConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }


}
