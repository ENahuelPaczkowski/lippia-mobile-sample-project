package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.constants.LoginConstants;
import org.testng.Assert;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class HomeService {

    public static void isViewLoaded() {
        MobileActionManager.waitVisibility(HomeConstants.ADD_TIME_BUTTON_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(HomeConstants.ADD_TIME_BUTTON_LOCATOR), "Login fallido");
    }

    public static void logout() {
        MobileActionManager.waitClickable(HomeConstants.LOGOUT_BUTTON);
        MobileActionManager.click(HomeConstants.LOGOUT_BUTTON);
        MobileActionManager.waitClickable(HomeConstants.CONFIRM_BUTTON);
        MobileActionManager.click(HomeConstants.CONFIRM_BUTTON);
    }

    public static void getOptions() {
        MobileActionManager.waitClickable(HomeConstants.OPTIONS_BUTTON);
        MobileActionManager.click(HomeConstants.OPTIONS_BUTTON);
    }
}
