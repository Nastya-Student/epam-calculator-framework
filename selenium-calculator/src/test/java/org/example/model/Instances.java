package org.example.model;

import java.util.Objects;

public class Instances {
    private String numberOfInstances;
    private String operatingSystem;
    private String provisioningModel;
    private String series;
    private String machineType;
    private String datacenterLocation;
    private String gpuType;
    private String numberOfGPUs;
    private String localSSD;
    private String committedUsage;
    private String estimate;

    public Instances(String numberOfInstances, String operatingSystem, String provisioningModel, String series, String machineType, String datacenterLocation, String gpuType, String numberOfGPUs, String localSSD, String committedUsage, String estimate) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.provisioningModel = provisioningModel;
        this.series = series;
        this.machineType = machineType;
        this.datacenterLocation = datacenterLocation;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.committedUsage = committedUsage;
        this.estimate = estimate;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instances instances = (Instances) o;
        return Objects.equals(numberOfInstances, instances.numberOfInstances) && Objects.equals(operatingSystem, instances.operatingSystem) && Objects.equals(provisioningModel, instances.provisioningModel) && Objects.equals(series, instances.series) && Objects.equals(machineType, instances.machineType) && Objects.equals(datacenterLocation, instances.datacenterLocation) && Objects.equals(gpuType, instances.gpuType) && Objects.equals(numberOfGPUs, instances.numberOfGPUs) && Objects.equals(localSSD, instances.localSSD) && Objects.equals(committedUsage, instances.committedUsage) && Objects.equals(estimate, instances.estimate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, provisioningModel, series, machineType, datacenterLocation, gpuType, numberOfGPUs, localSSD, committedUsage, estimate);
    }

    @Override
    public String toString() {
        return "Instances{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", estimate='" + estimate + '\'' +
                '}';
    }
}
