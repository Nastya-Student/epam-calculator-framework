package org.example.test;

import org.example.model.Instances;
import org.example.page.CloudGooglePage;
import org.example.service.InstancesCreater;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTests extends CommonConditions {


    @Test
    public void checkEqualityVMClass() {
        Instances testInstances = InstancesCreater.createInstances();
        String VMSClass = new CloudGooglePage(driver, testInstances)
                .openPage().searchCalculator(searchText)
                .clickLinkToCalculator()
                .activateComputeEngine()
                .fillForm(driver)
                .getProvisioningModel();
        Assert.assertEquals(VMSClass, testInstances.getProvisioningModel());
    }

    @Test
    public void checkEqualityInstanceType() {
        Instances testInstances = InstancesCreater.createInstances();
        String instanceType = new CloudGooglePage(driver, testInstances)
                .openPage().searchCalculator(searchText)
                .clickLinkToCalculator()
                .activateComputeEngine()
                .fillForm(driver)
                .getInstanceType();
        Assert.assertEquals(instanceType, testInstances.getMachineType());
    }

    @Test
    public void checkEqualityRegion() {
        Instances testInstances = InstancesCreater.createInstances();
        String region = new CloudGooglePage(driver, testInstances)
                .openPage().searchCalculator(searchText)
                .clickLinkToCalculator()
                .activateComputeEngine()
                .fillForm(driver)
                .getRegion();
        Assert.assertEquals(region, testInstances.getDatacenterLocation());
    }

    @Test
    public void checkEqualityLocalSSD() {
        Instances testInstances = InstancesCreater.createInstances();
        String localSSD = new CloudGooglePage(driver, testInstances)
                .openPage().searchCalculator(searchText)
                .clickLinkToCalculator()
                .activateComputeEngine()
                .fillForm(driver)
                .getLocalSSD();
        Assert.assertEquals(localSSD, testInstances.getLocalSSD());
    }

    @Test
    public void checkEqualityCommitmentTerm() {
        Instances testInstances = InstancesCreater.createInstances();
        String commitmentTerm = new CloudGooglePage(driver, testInstances)
                .openPage().searchCalculator(searchText)
                .clickLinkToCalculator()
                .activateComputeEngine()
                .fillForm(driver)
                .getCommitmentTerm();
        Assert.assertEquals(commitmentTerm, testInstances.getCommittedUsage());
    }


    @Test
    public void checkEstimateFromLetter() {
        Instances testInstances = InstancesCreater.createInstances();
        String estimate = new CloudGooglePage(driver, testInstances)
                .openPage().searchCalculator(searchText)
                .clickLinkToCalculator()
                .activateComputeEngine()
                .fillForm(driver)
                .getEstimatedCostFromLetter(driver);
        Assert.assertEquals(estimate, testInstances.getEstimate());
    }

}