package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.AddTimeConstants;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.services.AddTimeService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddTimeSteps extends PageSteps {

    @When("click on Add time entry button")
    public void clickOnAddTimeEntryButton() {
        MobileActionManager.click(HomeConstants.ADD_TIME_BUTTON_LOCATOR);
    }

    @And("Add hours '(.*)'")
    public void addHoursHours(String hours) {
        AddTimeService.setHours(hours);
    }


    @And("Add minutes '(.*)'")
    public void addMinutesMinutes(String minutes) {
        AddTimeService.setMinutes(minutes);
    }

    @And("Save new time")
    public void saveNewTime() {
        MobileActionManager.click(AddTimeConstants.SAVE_BUTTON);
    }

    @Then("Verify added time")
    public void verifyAddedTime() {
        AddTimeService.verifyNewTime();
    }

    @When("Delete entry")
    public void deleteEntry() {
        AddTimeService.deleteEntry();
    }

    @Then("verify no time entries")
    public void verifyNoTimeEntries() {
        MobileActionManager.waitVisibility(AddTimeConstants.NO_TIME_ENTRIES);
        Assert.assertTrue(MobileActionManager.isVisible(AddTimeConstants.NO_TIME_ENTRIES));
    }
}
