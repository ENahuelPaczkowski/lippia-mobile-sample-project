package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.SignUpConstants;

import java.util.Random;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class SignUpService {


    public static void regist() {

        setEmail();
        setPassword();
        clickSingup();
    }

    public static String generateRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString()+"@gmail.com";
    }

    public static void setEmail() {
        String email = generateRandomEmail();

        MobileActionManager.setInput(SignUpConstants.EMAIL_INPUT_LOCATOR, email);
    }

    public static void setPassword() {
        MobileActionManager.setInput(SignUpConstants.PASSWORD_INPUT_LOCATOR, "123456");
    }

    public static void clickSingup(){
        MobileActionManager.waitClickable(SignUpConstants.SIGN_UP_BUTTON_LOCATOR);
        MobileActionManager.click(SignUpConstants.SIGN_UP_BUTTON_LOCATOR);
    }
}
