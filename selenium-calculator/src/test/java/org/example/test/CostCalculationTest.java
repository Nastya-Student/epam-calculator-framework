package org.example.test;

import org.example.model.Instances;
import org.example.page.CloudGooglePage;
import org.example.service.InstancesCreater;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CostCalculationTest extends CommonConditions {
    @Test
    public void checkEstimateFromCalculatorPage() {
        Instances testInstances = InstancesCreater.createInstances();
        String estimate = new CloudGooglePage(driver, testInstances)
                .openPage().searchCalculator(searchText)
                .clickLinkToCalculator()
                .activateComputeEngine()
                .fillForm(driver)
                .getEstimatedComponentCostFromCalculatorPage();
        Assert.assertEquals(estimate, testInstances.getEstimate());
    }
}
