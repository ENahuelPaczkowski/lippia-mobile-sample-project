package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.AddTimeConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddTimeService {

    public static void setHours(String hours) {
        WebElement element = MobileActionManager.getElement(AddTimeConstants.HOURS_INPUT);
        while (!element.getText().equals(hours)){
            MobileActionManager.click(AddTimeConstants.INCREASE_HOUR);
        }
    }

    public static void setMinutes(String minutes) {
        WebElement element = MobileActionManager.getElement(AddTimeConstants.MINUTES_INPUT);
        while (!element.getText().equals(minutes)){
            MobileActionManager.click(AddTimeConstants.INCREASE_MINUTES);
        }
    }

    public static void verifyNewTime() {
        MobileActionManager.waitVisibility(AddTimeConstants.TIME_ENTRY);
        Assert.assertTrue(MobileActionManager.isVisible(AddTimeConstants.TIME_ENTRY), "No se puede verificar nueva entrada");
    }

    public static void deleteEntry() {
        MobileActionManager.waitClickable(AddTimeConstants.ENTRY_OPTIONS);
        MobileActionManager.click(AddTimeConstants.ENTRY_OPTIONS);
        MobileActionManager.waitClickable(AddTimeConstants.DELETE_BUTTON);
        MobileActionManager.click(AddTimeConstants.DELETE_BUTTON);
    }
}
