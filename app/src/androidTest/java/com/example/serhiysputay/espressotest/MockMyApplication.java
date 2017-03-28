package com.example.serhiysputay.espressotest;

/**
 * Mock real MyApplication class
 */

public class MockMyApplication extends MyApplication
{
    @Override
    protected DataServiceComponent createComponent()
    {
        return DaggerExampleInstrumentedTest_TestDataServiceComponent.builder().build();
    }
}
