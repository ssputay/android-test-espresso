package com.example.serhiysputay.espressotest;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Mock data service class for functional tests
 */
@Module
public class MockDataServiceModule
{
    @Provides
    @Singleton
    DataService provideDataService()
    {
        return Mockito.spy(DataService.getInstance());
    }
}
