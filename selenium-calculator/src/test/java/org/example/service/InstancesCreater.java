package org.example.service;

import org.example.model.Instances;

public class InstancesCreater {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number.of.instances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.operating.system";
    public static final String TESTDATA_PROVISIONING_MODEL = "testdata.provisioning.model";
    public static final String TESTDATA_SERIES = "testdata.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.datacenter.location";
    public static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.number.of.gpus";
    public static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    public static final String TESTATE_COMMITTED_USAGE = "testdata.committed.usage";
    public static final String TESTDATA_ESTIMATE = "testdata.estimate";

    public static Instances createInstances() {
        return new Instances(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTATE_COMMITTED_USAGE),
                TestDataReader.getTestData(TESTDATA_ESTIMATE));
    }
}
